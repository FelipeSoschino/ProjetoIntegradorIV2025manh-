package com.senac.forum_musicos.DTO;


import com.senac.forum_musicos.entity.Role;

import java.util.List;

public record RecoveryUserDTO(

        Long id,
        String email,
        List<Role> roles

) {
}