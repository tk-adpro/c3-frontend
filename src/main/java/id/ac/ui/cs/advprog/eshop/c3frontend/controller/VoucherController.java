package id.ac.ui.cs.advprog.eshop.c3frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VoucherController {

    @GetMapping("/vouchers")
    public String voucherDashboard() {
        return "voucher/voucherDashboard";
    }
    @GetMapping("/vouchers/create")
    public String createVoucher() {
        return "voucher/createVoucher";
    }
    @GetMapping("/vouchers/edit")
    public String editVoucher() {
        return "voucher/editVoucher";
    }

}