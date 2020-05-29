package com.community.services.pojo.orders;

/**
 * 订单信息
 */
public class Orders {

    private int id;
    private String plat_oid;
    private int user_id;
    private int product_id;
    private int buy_cnt;
    private String trade_no;
    private Double price;
    private Double real_price;
    private int pay_type;
    private Double pay_amount;
    private int pay_state;
    private int order_state;
    private String addr;
    private String NAME;
    private String phone;
    private String msg;
    private String extra;
    private String create_time;
    private String end_time;
    private String pay_time;
    private int shop_num;
    private String only_order;
    private int mark;
    private String pcids;
    private int sales_shop;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlat_oid() {
        return plat_oid;
    }

    public void setPlat_oid(String plat_oid) {
        this.plat_oid = plat_oid;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getBuy_cnt() {
        return buy_cnt;
    }

    public void setBuy_cnt(int buy_cnt) {
        this.buy_cnt = buy_cnt;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getReal_price() {
        return real_price;
    }

    public void setReal_price(Double real_price) {
        this.real_price = real_price;
    }

    public int getPay_type() {
        return pay_type;
    }

    public void setPay_type(int pay_type) {
        this.pay_type = pay_type;
    }

    public Double getPay_amount() {
        return pay_amount;
    }

    public void setPay_amount(Double pay_amount) {
        this.pay_amount = pay_amount;
    }

    public int getPay_state() {
        return pay_state;
    }

    public void setPay_state(int pay_state) {
        this.pay_state = pay_state;
    }

    public int getOrder_state() {
        return order_state;
    }

    public void setOrder_state(int order_state) {
        this.order_state = order_state;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getPhon() {
        return phone;
    }

    public void setPhon(String phon) {
        this.phone = phon;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getPay_time() {
        return pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }

    public int getShop_num() {
        return shop_num;
    }

    public void setShop_num(int shop_num) {
        this.shop_num = shop_num;
    }

    public String getOnly_order() {
        return only_order;
    }

    public void setOnly_order(String only_order) {
        this.only_order = only_order;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getPcids() {
        return pcids;
    }

    public void setPcids(String pcids) {
        this.pcids = pcids;
    }

    public int getSales_shop() {
        return sales_shop;
    }

    public void setSales_shop(int sales_shop) {
        this.sales_shop = sales_shop;
    }

    @Override
    public String toString() {
        return "Community_orders{" +
                "id=" + id +
                ", plat_oid='" + plat_oid + '\'' +
                ", user_id=" + user_id +
                ", product_id=" + product_id +
                ", buy_cnt=" + buy_cnt +
                ", trade_no='" + trade_no + '\'' +
                ", price=" + price +
                ", real_price=" + real_price +
                ", pay_type=" + pay_type +
                ", pay_amount=" + pay_amount +
                ", pay_state=" + pay_state +
                ", order_state=" + order_state +
                ", addr='" + addr + '\'' +
                ", NAME='" + NAME + '\'' +
                ", phon='" + phone + '\'' +
                ", msg='" + msg + '\'' +
                ", extra='" + extra + '\'' +
                ", create_time='" + create_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", pay_time='" + pay_time + '\'' +
                ", shop_num=" + shop_num +
                ", only_order='" + only_order + '\'' +
                ", mark=" + mark +
                ", pcids='" + pcids + '\'' +
                ", sales_shop=" + sales_shop +
                '}';
    }
}
