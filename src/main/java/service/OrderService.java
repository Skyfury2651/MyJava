package service;

import entity.Order;
import entity.OrderDetail;
import repository.OrderDetailRepository;
import repository.OrderRepository;

import java.util.List;

public class OrderService {
    private OrderRepository orderRepository;
    private OrderDetailRepository orderDetailRepository;

    public OrderService() {
        this.orderRepository = new OrderRepository();
        this.orderDetailRepository = new OrderDetailRepository();
    }

    public boolean createOrder(Order order, List<OrderDetail> listOrderDetail) {
        // lưu đơn hàng.
        // đặt trong transaction.
        this.orderRepository.save(order);
        for (OrderDetail orderDetail : listOrderDetail) {
            this.orderDetailRepository.save(orderDetail);
        }
        // lưu đơn hàng chi tiết.
        return false;
    }
}
