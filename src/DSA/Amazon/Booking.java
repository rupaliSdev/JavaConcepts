package DSA.Amazon;

public class Booking {
}
private boolean deleted = false;

public boolean isDeleted() {
    return deleted;
}

public void setDeleted(boolean deleted) {
    this.deleted = deleted;
}



@Repository
public class HotelRepository {

    private final Map<Long, Hotel> hotels = new ConcurrentHashMap<>();

    public Optional<Hotel> findById(Long id) {
        return Optional.ofNullable(hotels.get(id));
    }

    public List<Hotel> findAll() {
        return new ArrayList<>(hotels.values());
    }

    public void save(Hotel hotel) {
        hotels.put(hotel.getId(), hotel);
    }
}

@Service
public class DefaultHotelService implements HotelService {

    private final HotelRepository hotelRepository;

    public DefaultHotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel getHotelById(Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException("Hotel not found"));

        if (hotel.isDeleted()) {
            throw new ElementNotFoundException("Hotel not found");
        }

        return hotel;
    }

    @Override
    public void deleteHotel(Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ElementNotFoundException("Hotel not found"));

        hotel.setDeleted(true);
    }

    @Override
    public List<Hotel> searchClosestHotels(Long cityId) {

        List<Hotel> hotels = hotelRepository.findAll()
                .stream()
                .filter(h -> !h.isDeleted())
                .filter(h -> h.getCity().getId().equals(cityId))
                .toList();

        if (hotels.isEmpty()) return List.of();

        City city = hotels.get(0).getCity();

        return hotels.stream()
                .sorted(Comparator.comparingDouble(h ->
                        Haversine.distance(
                                h.getLatitude(),
                                h.getLongitude(),
                                city.getCityCentreLatitude(),
                                city.getCityCentreLongitude()
                        )))
                .limit(3)
                .toList();
    }
}
@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable Long id) {
        return ResponseEntity.ok(hotelService.getHotelById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.ok().build();
    }
}
@GetMapping("/search/{cityId}")
public ResponseEntity<List<Hotel>> search(
        @PathVariable Long cityId,
        @RequestParam String sortBy) {

    if (!"distance".equals(sortBy)) {
        throw new BadRequestException("Invalid sort");
    }

    return ResponseEntity.ok(
            hotelService.searchClosestHotels(cityId)
    );
}
public class Haversine {

    private static final int EARTH_RADIUS = 6371;

    public static double distance(double lat1, double lon1,
                                  double lat2, double lon2) {

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(dLat / 2), 2)
                + Math.pow(Math.sin(dLon / 2), 2)
                * Math.cos(lat1)
                * Math.cos(lat2);

        double c = 2 * Math.asin(Math.sqrt(a));

        return EARTH_RADIUS * c;
    }
}
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(String message) {
        super(message);
    }
}
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}