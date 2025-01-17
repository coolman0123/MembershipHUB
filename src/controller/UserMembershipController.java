package controller;

import java.util.List;
import model.User;
import model.dao.UserDao;
import view.UserUI;

public class UserMembershipController {
    public void run() {
        UserUI userUI = new UserUI();
        UserDao userDao = new UserDao("src/tmp/Users.DAT");
        List<User> users = userDao.loadUsers(); //파일에 있는 회원 목록
        while (true) {
            int menuID = userUI.menu();
            if (menuID == 3) {
                System.out.println("프로그램 종료");
                userDao.saveUser(users); //종료시 현재 users 정보를 저장
                break;
            } else if (menuID == 1) {
                User user = userUI.regUser();
                users.add(user);
                System.out.println("등록되었습니다.");
            } else if (menuID == 2) {
                userUI.printUserList(users);

            }
        }
    }
}
