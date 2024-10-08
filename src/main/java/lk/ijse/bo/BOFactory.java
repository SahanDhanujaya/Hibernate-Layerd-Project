package lk.ijse.bo;

import lk.ijse.bo.custom.impl.CustomerBOImpl;
import lk.ijse.bo.custom.impl.ItemBOImpl;
import lk.ijse.bo.custom.impl.OrderBOImpl;
import lk.ijse.bo.custom.impl.OrderDetailBOImpl;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){}

    public enum BOType{
        CUSTOMER,ITEM,ORDER,ORDER_DETAIL
    }

    public static BOFactory getBOFactory(){
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }
    public SuperBO getBOType(BOType boType){
        switch (boType){
            case CUSTOMER :
                return new CustomerBOImpl();
            case ITEM :
                return new ItemBOImpl();
            case ORDER:
                return new OrderBOImpl();
            case ORDER_DETAIL:
                return new OrderDetailBOImpl();
            default:
                return null;
        }
    }
}
