package LLD_Design;

import java.util.*;

public class CouponSystem {


    public CouponSystem(List<Category> categories, Map<String, List<Coupon>> coupons) {

        for(Category category : categories){
            map.put(category.name, new Node(category.name));
        }

        for(Category category : categories){
            Node node = map.get(category.name);
            if(category.parent == null){
                root = node;
            }else{
                Node parentNode = map.get(category.parent);
                parentNode.children.add(node);
            }
        }
        computeOwnBestCoupons(coupons);
        dfs(root,null);
    }

    public void dfs(Node node, Coupon inherited){
        if(node.bestOwnCoupon!=null){
            node.effectiveCoupon=node.bestOwnCoupon;
        }
        else {
            node.effectiveCoupon=inherited;

        }

        for (Node cnode: node.children){
            dfs(cnode,inherited);
        }

    }

    private void computeOwnBestCoupons(Map<String, List<Coupon>> coupons) {
        Date now = new Date();
        for(String categoryName : coupons.keySet()){
            List<Coupon> couponList = coupons.get(categoryName);
            Coupon bestCoupon = null;
            for(Coupon coupon : couponList){
                if(coupon.isActive && !coupon.dateModified.after(now)){
                    if(bestCoupon == null || coupon.dateModified.after(bestCoupon.dateModified)){
                        bestCoupon = coupon;
                    }
                }
            }
            if(bestCoupon != null){
                map.get(categoryName).bestOwnCoupon = bestCoupon;
            }
        }


    }

    static class Category{
        String name;
        String parent;

        public Category(String name, String parent) {
            this.name = name;
            this.parent = parent;
        }
    }
    static  class  Coupon{
        String couponName;
        Date dateModified;
        boolean isActive;
        double discount;

        public Coupon(String couponName, Date dateModified, boolean b, double discount) {
            this.couponName = couponName;
            this.dateModified = dateModified;
            this.isActive= b;
            this.discount = discount;
        }
    }
    public static void main(String[] args) {

        List<Category> categories = Arrays.asList(
                new Category("Home", null),
                new Category("Bed & Bath", "Home"),
                new Category("Comforters", "Bed & Bath"),
                new Category("Comforter Sets", "Comforters"),
                new Category("Baby & Kids", "Home"),
                new Category("Toy Organizers", "Baby & Kids")
        );

        Map<String, List<Coupon>> coupons = new HashMap<>();

        coupons.put("Bed & Bath", Arrays.asList(
                new Coupon("BedBath10%", new Date(System.currentTimeMillis() - 10000), true, 10)
        ));

        coupons.put("Comforter Sets", Arrays.asList(
                new Coupon("ComforterSale20", new Date(System.currentTimeMillis() - 5000), false, 20)
        ));

        CouponSystem system = new CouponSystem(categories, coupons);
        system.getEffectiveCoupon(categories,coupons);





    }


    private void getEffectiveCoupon(List<Category> categories, Map<String, List<Coupon>> coupons) {

        

    }

    Map<String, Node> map = new HashMap<>();
    Node root;
    static class Node {
        String name;
        List<Node> children = new ArrayList<>();
        Coupon bestOwnCoupon;       // best coupon in this category
        Coupon effectiveCoupon;     // inherited coupon

        Node(String name) {
            this.name = name;
        }
    }
}
