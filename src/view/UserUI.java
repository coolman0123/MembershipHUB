package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import model.User;

public class UserUI {
    private BufferedReader br;

    public UserUI() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int menu() {
        System.out.println("1. 회원등록");
        System.out.println("2. 회원목록 보기");
        System.out.println("3. 회원 정보 수정 ");
        System.out.println("4. 회원 정보 삭제");
        System.out.println("5. 종료");
        int menuId = -1;
        try {
            String line = br.readLine();
            menuId = Integer.parseInt(line);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return menuId;
    }

    public User regUser() {
        try {
            System.out.println("이메일을 입력하세요.");
            String email = br.readLine();

            System.out.println("이름을 입력하세요.");
            String name = br.readLine();

            System.out.println("생년을 입력하세요");
            String strbirthYear = br.readLine();
            int birthYear = Integer.parseInt(strbirthYear);

            User user = new User(email, name, birthYear);

            return user;
        } catch (Exception ex) {
            ex.printStackTrace();

            return null;
        }
    }

    public void printUserList(List<User> users) {
        System.out.println("email          이름          생년");
        System.out.println("===============================");

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);

            System.out.print(user.getEmail());
            System.out.print("          ");
            System.out.print(user.getName());
            System.out.print("          ");
            System.out.println(user.getBirthYear());
        }
    }

    public void modifyUser(List<User> users) {
        try {
            System.out.println("수정할 회원 email을 입력하세요.");
            String userEmail = br.readLine();

            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                String email = user.getEmail();
                if (userEmail.equals(email)) {
                    System.out.println("회원의 새로운 이름을 입력하세요");
                    String userName = br.readLine();
                    user.setName(userName);

                    System.out.println("회원의 새로운 생년을 입력하세요");
                    int userBirthYear = Integer.parseInt(br.readLine());
                    user.setBirthYear(userBirthYear);
                } else {
                    System.out.println("해당 메일로 가입된 회원이 없습니다.");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void deleteUser(List<User> users) {
        System.out.println("삭제할 회원의 email을 입력하세요");
        try {
            String userEmail = br.readLine();

            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                String email = user.getEmail();
                if (userEmail.equals(email)) {
                    users.remove(user);
                    System.out.println("삭제되었습니다.");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
