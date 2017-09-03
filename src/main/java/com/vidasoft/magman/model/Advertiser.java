package com.vidasoft.magman.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAdvertisersByPackage",
                query = "SELECT adv FROM Advertiser adv WHERE adv.sponsorPackage = :sponsorPackage")
})
public class Advertiser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private int version;

    private String name;
    private String website;
    private String contactEmail;
    @Lob
    private byte[] logo;
    @Enumerated(EnumType.STRING)
    private SponsorPackage sponsorPackage;

    public Advertiser() {
    }

    public Advertiser(String name, String website, String contactEmail, SponsorPackage sponsorPackage) {
        this(name, website, contactEmail, null, sponsorPackage);
    }

    public Advertiser(String name, String website, String contactEmail, byte[] logo, SponsorPackage sponsorPackage) {
        this.name = name;
        this.website = website;
        this.contactEmail = contactEmail;
        this.logo = logo;
        this.sponsorPackage = sponsorPackage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public SponsorPackage getSponsorPackage() {
        return sponsorPackage;
    }

    public void setSponsorPackage(SponsorPackage sponsorPackage) {
        this.sponsorPackage = sponsorPackage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertiser that = (Advertiser) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(website, that.website) &&
                Objects.equals(contactEmail, that.contactEmail) &&
                sponsorPackage == that.sponsorPackage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, website, contactEmail, sponsorPackage);
    }

    @Override
    public String toString() {
        return "Advertiser{" +
                "name='" + name + '\'' +
                ", website='" + website + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", sponsorPackage=" + sponsorPackage +
                '}';
    }
}
