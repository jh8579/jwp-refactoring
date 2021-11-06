package kitchenpos.application;

import kitchenpos.dao.MenuGroupDao;
import kitchenpos.domain.MenuGroup;
import kitchenpos.dto.MenuGroupDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuGroupService {
    private final MenuGroupDao menuGroupDao;

    public MenuGroupService(final MenuGroupDao menuGroupDao) {
        this.menuGroupDao = menuGroupDao;
    }

    @Transactional
    public MenuGroupDto create(final MenuGroupDto menuGroupDto) {
        MenuGroup save = menuGroupDao.save(menuGroupDto.toMenuGroup());
        return MenuGroupDto.from(save);
    }

    public List<MenuGroupDto> list() {
        return menuGroupDao.findAll()
                           .stream()
                           .map(MenuGroupDto::from)
                           .collect(Collectors.toList());
    }
}
