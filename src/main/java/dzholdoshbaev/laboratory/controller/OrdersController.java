package dzholdoshbaev.laboratory.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {

//    @GetMapping("/{dishId}")
//    private String addDishToOrder(@RequestParam Long dishId, HttpSession session, Model model) {
//        Long sessionId = session.getId();
//    }


}
