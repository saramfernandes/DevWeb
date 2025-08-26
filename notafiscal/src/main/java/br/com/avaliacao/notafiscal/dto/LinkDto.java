package br.com.avaliacao.notafiscal.dto;

public class LinkDto {
    private final String rel;
    private final String href;
    private final String verb;

    public LinkDto(String rel, String href, String verb) {
        this.rel = rel;
        this.href = href;
        this.verb = verb;
    }

    public String getRel() {
        return rel;
    }

    public String getHref() {
        return href;
    }

    public String getVerb() {
        return verb;
    }
}
