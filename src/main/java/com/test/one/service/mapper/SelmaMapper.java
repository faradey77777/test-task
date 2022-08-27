package com.test.one.service.mapper;


import com.test.one.domain.User;
import com.test.one.dto.UserDto;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

@Mapper(withIoC = IoC.SPRING)
public interface SelmaMapper {
    @Maps
    User mapTo(UserDto source);

    @Maps
    UserDto mapFrom(User source);
}
