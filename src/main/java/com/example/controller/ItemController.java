package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.entity.Item;
import com.example.service.ItemService;

@Controller
public class ItemController {
    /* ☆追加箇所：Serviceクラス用のフィールドを追加する☆ */
    private final ItemService itemService;

   /* ☆追加箇所：Serviceクラスのインスタンスをフィールドにセットする☆ */
    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        /* ☆修正箇所：商品の一覧を取得して、htmlで扱えるようにする☆ */
        List<Item> items = this.itemService.findAll();
        model.addAttribute("items", items);
        return "index";
    }
}