package com.empregospernambuco1.automation;

public class JobAutomation {
    private String title;
    private String empresa;
    private String cidade;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "JobAutomation{" +
                "title='" + title + '\'' +
                ", empresa='" + empresa + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
