package entity;

public class UserFactory {
    //** Requires: password is valid.
    public User create(int id, String username, String password) {
        return new User(id, username, password);
    }
}
// 我们不要你了