package org.example.made4u.core.presentation;


import lombok.RequiredArgsConstructor;
import org.example.made4u.core.domain.buy.service.CommendPurchaseDataService;
import org.example.made4u.core.domain.buy.service.CommendShoppingItemService;
import org.example.made4u.core.domain.buy.service.FindPurchaseDataService;
import org.example.made4u.core.domain.buy.service.FindShoppingItemService;
import org.example.made4u.persistence.product.entity.ShoppingBagItemJpaEntity;
import org.example.made4u.persistence.user.entity.PurchaseDetailJpaEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/buy")
public class BuyWebAdapter {
    private final CommendShoppingItemService commendShoppingItemService;
    private final CommendPurchaseDataService commendPurchaseDataService;
    private final FindShoppingItemService findShoppingItemService;
    private final FindPurchaseDataService findPurchaseDataService;

    @PostMapping("/add/{productId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addItem(@PathVariable String productId) {
        commendShoppingItemService.createItem(productId);
    }

    @DeleteMapping("/del/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable String productId) {
        commendShoppingItemService.deleteItem(productId);
    }

    @GetMapping("/shopping-bag")
    @ResponseStatus(HttpStatus.OK)
    public List<ShoppingBagItemJpaEntity> getShoppingBag() {
        return findShoppingItemService.getItems();
    }

    @PostMapping("/purchase")
    @ResponseStatus(HttpStatus.CREATED)
    public void buyItems() {
        commendPurchaseDataService.purchase();
    }

    @GetMapping("/purchase-data")
    @ResponseStatus(HttpStatus.OK)
    public List<PurchaseDetailJpaEntity> getPurchaseData() {
        return findPurchaseDataService.getData();
    }
}
