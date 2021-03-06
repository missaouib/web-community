package me.lozm.data;

import com.github.javafaker.Faker;
import me.lozm.object.code.UsersType;
import me.lozm.object.dto.user.UserPostDto;
import me.lozm.object.dto.user.UserPutDto;

import java.util.concurrent.ThreadLocalRandom;

public class UserTestDto {

    private static Faker faker = new Faker();
    private static final String USER_PASSWORD = "asdfasdf1234";


    public static UserPostDto.Request makeTestUserPostDto() {
        return UserPostDto.Request.builder()
                .name(faker.name().fullName())
                .identifier(faker.pokemon().name())
                .password(USER_PASSWORD)
                .type(getRandomUserType())
                .build();
    }

    public static UserPostDto.Request makeTestUserPostDto(String name, String identifier) {
        return UserPostDto.Request.builder()
                .name(name)
                .identifier(identifier)
                .password(USER_PASSWORD)
                .type(getRandomUserType())
                .build();
    }

    public static UserPutDto.Request makeTestUserPutDto(Long userId, String name, String identifier, String password) {
        return UserPutDto.Request.builder()
                .id(userId)
                .name(name)
                .identifier(identifier)
                .password(password)
                .type(getRandomUserType())
                .build();
    }

    private static UsersType getRandomUserType() {
        UsersType[] usersTypeArr = UsersType.values();
        return usersTypeArr[ThreadLocalRandom.current().nextInt(0, usersTypeArr.length - 1)];
    }

}
