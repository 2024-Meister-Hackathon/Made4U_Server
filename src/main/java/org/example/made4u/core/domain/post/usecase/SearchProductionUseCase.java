package org.example.made4u.core.domain.post.usecase;

import lombok.RequiredArgsConstructor;
import org.example.made4u.core.domain.post.dto.response.searchProduction.SearchProductionResponse;
import org.example.made4u.core.domain.post.dto.response.searchProduction.SearchResultDto;
import org.example.made4u.core.domain.post.service.FindProductionService;
import org.example.made4u.persistence.product.entity.ProductJpaEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SearchProductionUseCase {
    private final FindProductionService findProductionService;

    public SearchProductionResponse execute(String keyword) {
        List<ProductJpaEntity> productEntities = findProductionService.findAllProductionNameLike(keyword);

        List<SearchResultDto> searchData = productEntities.stream()
                .map(data -> new SearchResultDto(data.getProductId().toString(), data.getName())).toList();

        return new SearchProductionResponse(searchData);
    }
}
