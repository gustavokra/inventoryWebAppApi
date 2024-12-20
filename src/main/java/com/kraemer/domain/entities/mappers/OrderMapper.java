package com.kraemer.domain.entities.mappers;

import com.kraemer.domain.entities.OrderBO;
import com.kraemer.domain.entities.dto.OrderDTO;
import com.kraemer.domain.entities.vo.CreatedAtVO;

public class OrderMapper {

    public static OrderBO toBO(OrderDTO dto) {
        if (dto == null) {
            return null;
        }

        return new OrderBO(
                dto.getId(),
                new CreatedAtVO(dto.getCreatedAt()),
                dto.getClient() != null ? ClientMapper.toBO(dto.getClient()) : null,
                dto.getEnumStatus(),
                dto.getTotalValue(),
                dto.getItems().stream().map(OrderItemMapper::toBO).toList());
    }

    public static OrderDTO toDTO(OrderBO bo) {
        if (bo == null) {
            return null;
        }

        var dto = new OrderDTO();
        dto.setId(bo.getId());
        dto.setCreatedAt(bo.getCreatedAt().getValue());
        dto.setClient(bo.getClient() != null ? ClientMapper.toDTO(bo.getClient()) : null);
        dto.setEnumStatus(bo.getEnumStatus());
        dto.setTotalValue(bo.getTotalValue());
        dto.setItems(bo.getItemsBO().stream().map(OrderItemMapper::toDTO).toList());
        return dto;
    }

}
