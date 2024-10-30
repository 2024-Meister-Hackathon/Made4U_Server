package org.example.made4u.core.domain.post.dto.response.searchProduction;

import org.example.made4u.persistence.product.entity.UseJpaEntity;

import java.util.List;

public record SearchProductionResponse(
        List<SearchResultDto> results
) {
}
