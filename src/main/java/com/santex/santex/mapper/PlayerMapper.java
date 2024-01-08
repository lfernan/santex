package com.santex.santex.mapper;

import com.santex.santex.dto.response.PlayerDTO;
import com.santex.santex.entity.Player;

public class PlayerMapper {

    public static Player mapToEntity(PlayerDTO playerDTO) {
        Player player = new Player();
        player.setId(playerDTO.getId());
        player.setName(playerDTO.getName());
        player.setNationality(playerDTO.getNationality());
        player.setDateOfBirth(playerDTO.getDateOfBirth());
        player.setPosition(playerDTO.getPosition());

        return player;
    }

    public static PlayerDTO mapToDTO(Player player) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setName(player.getName());
        playerDTO.setPosition(player.getPosition());
        playerDTO.setNationality(player.getNationality());
        playerDTO.setDateOfBirth(player.getDateOfBirth());

        return playerDTO;
    }
}
