package br.com.fiap.Notificacao.de.acidentes.model;

public enum UsuarioRole {
    ADMIN("admin"),

    USER("user");

    private String role;

    UsuarioRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}


