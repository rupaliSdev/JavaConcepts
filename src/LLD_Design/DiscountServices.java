package LLD_Design;

import java.util.*;

public class DiscountServices {

    private static final String dateFormat = "yyyy-MM-dd";
    Map<String, String> parent = new HashMap<>(); //child->parent
    Map<String, List<Coupon>> categoryCoupon = new HashMap<>(); //category->coupon
    Map<String, Coupon> effectiveCoupon = new HashMap<>();//category->effective coupon
    Map<String, List<String>> children = new HashMap<>(); //parent ->child

    public DiscountServices() {
        preCompute();
    }

    public static void main(String[] args) {


        DiscountServices service = new DiscountServices();

        List<String[]> coupons = List.of(
                new String[]{"CategoryName:Comforter Sets", "CouponName:Comforters Sale", "DateModified:2020-01-01", "Discount:10%"},
                new String[]{"CategoryName:Comforter Sets", "CouponName:Cozy Comforter Coupon", "DateModified:2020-01-01", "Discount:$15"},
                new String[]{"CategoryName:Bedding", "CouponName:Best Bedding Bargains", "DateModified:2019-01-01", "Discount:35%"},
                new String[]{"CategoryName:Bedding", "CouponName:Savings on Bedding", "DateModified:2019-01-01", "Discount:25%"},
                new String[]{"CategoryName:Bed & Bath", "CouponName:Low price for Bed & Bath", "DateModified:2018-01-01", "Discount:50%"},
                new String[]{"CategoryName:Bed & Bath", "CouponName:Bed & Bath extravaganza", "DateModified:2019-01-01", "Discount:75%"}
        );

        List<String[]> categories = List.of(
                new String[]{"CategoryName:Comforter Sets", "CategoryParentName:Bedding"},
                new String[]{"CategoryName:Bedding", "CategoryParentName:Bed & Bath"},
                new String[]{"CategoryName:Bed & Bath", "CategoryParentName:None"},
                new String[]{"CategoryName:Soap Dispensers", "CategoryParentName:Bathroom Accessories"},
                new String[]{"CategoryName:Bathroom Accessories", "CategoryParentName:Bed & Bath"},
                new String[]{"CategoryName:Toy Organizers", "CategoryParentName:Baby And Kids"},
                new String[]{"CategoryName:Baby And Kids", "CategoryParentName:None"}
        );

        List<String[]> products = List.of(
                new String[]{"ProductName:Cozy Comforter Sets", "Price:100.00", "CategoryName:Comforter Sets"},
                new String[]{"ProductName:All-in-one Bedding Set", "Price:50.00", "CategoryName:Bedding"},
                new String[]{"ProductName:Infinite Soap Dispenser", "Price:500.00", "CategoryName:Bathroom Accessories"},
                new String[]{"ProductName:Rainbow Toy Box", "Price:257.00", "CategoryName:Baby And Kids"}
        );


        for (String[] category : categories) {
            service.addCategory(category[0].split(":")[1], category[1].split(":")[1]);
        }

        for (String[] couponStr : coupons) {
            String category = couponStr[0].split(":")[1];
            Coupon coupon = new Coupon(couponStr[1].split(":")[1], new Date(couponStr[2].split(":")[1]),
                    couponStr[3].split(":")[1].startsWith("$") ? CouponType.ABSOLUTE : CouponType.PERCENT);
            service.updateCoupon(category, coupon);
        }


    }

    private void addCategory(String category, String parentCategory) {
        parent.put(category, parentCategory);
        children.computeIfAbsent(parentCategory, k -> new ArrayList<>()).add(category);
    }


   /* First solution
    Represent tree

    Move upward until coupon found

    Time: O(height)*/

    //Naive lookup
    public Coupon getCouponI(String category) {
        String cur = category;
        while (cur != null) {
            if (categoryCoupon.containsKey(cur)) {
                return categoryCoupon.get(category).get(0);
            }
            cur = parent.get(category);
        }
        return null;
    }


    //    Precompute effective coupon for all categories
//
//    BFS/DFS
//
//    Store in HashMap
//
//    Time: O(N preprocessing), O(1) lookup
    public void preCompute() {

        Queue<String> categoryQueue = new LinkedList<>();
        for (String category : parent.keySet()) {
            if (parent.get(category) == null) {
                categoryQueue.offer(category);
                effectiveCoupon.put(category, computeEffectiveCoupon(categoryCoupon.get(category)));

            }
        }
        while (!categoryQueue.isEmpty()) {
            String category = categoryQueue.poll();
            Coupon inherited = effectiveCoupon.get(category);
            for (String child : children.getOrDefault(category, new ArrayList<>())) {
                if (categoryCoupon.containsKey(child)) {
                    List<Coupon> coupons = categoryCoupon.get(child);
                    effectiveCoupon.put(child, computeEffectiveCoupon(coupons));
                } else {
                    effectiveCoupon.put(child, inherited);
                }
                categoryQueue.offer(child);
            }
        }

    }
    //
//    3️⃣ Add timestamp/validity
//
//    During preprocessing choose the most recent valid coupon
//
//    Same complexity


    private Coupon computeEffectiveCoupon(List<Coupon> coupons) {
        Date now = new Date();
        Optional<Coupon> couponEffective = coupons.stream().filter(coupon -> coupon.getDateModified().before(now)).
                max(Comparator.comparing(Coupon::getDateModified));
        return couponEffective.get();
    }

    //O(1) lookUp
    public Coupon getCouponII(String category) {
        return effectiveCoupon.get(category);
    }

    /*  “Given a product price & category, return final discounted price.”*/


    public double getDiscountedPrice(String category, double price) {
        Coupon coupon = effectiveCoupon.get(category);
        if (coupon == null) return price;
        return coupon.couponType == CouponType.PERCENT ?
                price * (1 - coupon.getValue() / 100.0) : price - coupon.getValue();
    }


    public void updateCoupon(String category, Coupon newCoupon) {
        List<Coupon> coupons = categoryCoupon.getOrDefault(category, new ArrayList<>());
        coupons.add(newCoupon);
        categoryCoupon.put(category, coupons);
        effectiveCoupon.put(category, computeEffectiveCoupon(categoryCoupon.get(category)));
        recomputeSubtree(category);
    }

    private void recomputeSubtree(String category) {

        Queue<String> q = new LinkedList<>();
        q.add(category);

        while (!q.isEmpty()) {
            String cur = q.poll();

            Coupon inherited = effectiveCoupon.get(cur);
            for (String child : children.getOrDefault(cur, new ArrayList<>())) {
                if (categoryCoupon.containsKey(child)) {
                    List<Coupon> coupons = categoryCoupon.get(child);
                    effectiveCoupon.put(child, computeEffectiveCoupon(coupons));
                } else {
                    effectiveCoupon.put(child, inherited);
                }
                q.offer(child);
            }

        }
    }


    enum CouponType {
        ABSOLUTE,
        PERCENT
    }

    static class Coupon {
        String name;
        Date dateModified;
        CouponType couponType;
        double value;

        public Coupon(String name, Date dateModified, CouponType couponType) {
            this.name = name;
            this.dateModified = dateModified;
            this.couponType = couponType;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getDateModified() {
            return dateModified;
        }

        public void setDateModified(Date dateModified) {
            this.dateModified = dateModified;
        }

        public CouponType getCouponType() {
            return couponType;
        }

        public void setCouponType(CouponType couponType) {
            this.couponType = couponType;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }

    static class Category {
        String name;
        String parent;

        public Category(String name, String parent) {
            this.name = name;
            this.parent = parent;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }
    }


}
