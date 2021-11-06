package kitchenpos.dto;

import java.util.Objects;
import javax.validation.constraints.NotEmpty;

import kitchenpos.domain.MenuGroup;

public class MenuGroupDto {
    private Long id;

    @NotEmpty
    private String name;

    public MenuGroupDto() {
    }

    public MenuGroupDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public MenuGroup toMenuGroup() {
        if (Objects.isNull(id)) {
            return new MenuGroup(name);
        }
        return new MenuGroup(id, name);
    }

    public static MenuGroupDto from(MenuGroup menuGroup) {
        return new MenuGroupDto(menuGroup.getId(), menuGroup.getName());
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
