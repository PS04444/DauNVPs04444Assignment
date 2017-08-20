/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.TaiKhoan;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.ModelAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTaiKhoan {
    @RequestMapping("edit")
    public String edit(HttpServletRequest request, ModelMap model) {
        String user = request.getParameter("txtUser");
        String pass = request.getParameter("txtPass");
        String full = request.getParameter("txtFull");
        TaiKhoan tk = new TaiKhoan(user, pass, full);
        model.addAttribute("user", tk);

        List<TaiKhoan> list = new ArrayList<TaiKhoan>();
        list = ModelAccount.showTaiKhoan("");
        model.addAttribute("listUsers", list);
        return "qltaikhoan";
    }

    @RequestMapping("delete")
    public String delete(HttpServletRequest request, ModelMap model,
            @ModelAttribute("user") TaiKhoan tk) {
        String user = request.getParameter("txtUser");
        ModelAccount.delete(user);
        List<TaiKhoan> list = new ArrayList<TaiKhoan>();
        list = ModelAccount.showTaiKhoan("");
        model.addAttribute("listUsers", list);
        tk = list.get(0);
        model.addAttribute("user", tk);
        return "qltaikhoan";
    }

    @RequestMapping(params = "btnUpdate")
    public String update(@ModelAttribute("user") TaiKhoan tk, ModelMap model) {
        ModelAccount.update(tk);
        List<TaiKhoan> list = new ArrayList<TaiKhoan>();
        list = ModelAccount.showTaiKhoan("");
        model.addAttribute("listUsers", list);
        return "qltaikhoan";
    }

    @RequestMapping(params = "btnInsert")
    public String insert(@ModelAttribute("user") TaiKhoan tk, ModelMap model) {
        ModelAccount.insert(tk);
        List<TaiKhoan> list = new ArrayList<TaiKhoan>();
        list = ModelAccount.showTaiKhoan("");
        model.addAttribute("listUsers", list);
        return "qltaikhoan";
    }
}
