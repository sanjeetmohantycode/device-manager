package com.iot.platform.devicemanager.domain;


import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "organizationDetail", catalog = "org detail")
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDetail {

    @Id
    private String id;

    private String orgId;

    @OneToOne
    private Organization organization;

    private String freeCode1;

    private String freeCode2;

    private String freeCode3;

    private String freeCode4;

    private String freeCode5;

    private Integer freeCode6;

    private Integer freeCode7;

    private Integer freeCode8;

    private Integer freeCode9;

    private Integer freeCode10;

    private Double freeCode11;

    private Double freeCode12;

    private Long freeCode14;

    private Long freeCode15;

    private BigInteger freeCode16;

    private BigInteger freeCode17;

    private BigDecimal freeCode18;

    private BigDecimal freeCode19;

    @Override
    public String toString() {
        return "OrganizationDetail{" + "id='" + id + "'," + "orgId='" + orgId + "'," + "organization='" + organization + "'," + "freeCode1='" + freeCode1 + "'," + "freeCode2='" + freeCode2 + "'," + "freeCode3='" + freeCode3 + "'," + "freeCode4='" + freeCode4 + "'," + "freeCode5='" + freeCode5 + "'," + "freeCode6='" + freeCode6 + "'," + "freeCode7='" + freeCode7 + "'," + "freeCode8='" + freeCode8 + "'," + "freeCode9='" + freeCode9 + "'," + "freeCode10='" + freeCode10 + "'," + "freeCode11='" + freeCode11 + "'," + "freeCode12='" + freeCode12 + "'," + "freeCode14='" + freeCode14 + "'," + "freeCode15='" + freeCode15 + "'," + "freeCode16='" + freeCode16 + "'," + "freeCode17='" + freeCode17 + "'," + "freeCode18='" + freeCode18 + "'," + "freeCode19='" + freeCode19 + "'" + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationDetail that = (OrganizationDetail) o;
        return java.util.Objects.equals(id, that.id) &&
                java.util.Objects.equals(orgId, that.orgId) &&
                java.util.Objects.equals(organization, that.organization) &&
                java.util.Objects.equals(freeCode1, that.freeCode1) &&
                java.util.Objects.equals(freeCode2, that.freeCode2) &&
                java.util.Objects.equals(freeCode3, that.freeCode3) &&
                java.util.Objects.equals(freeCode4, that.freeCode4) &&
                java.util.Objects.equals(freeCode5, that.freeCode5) &&
                java.util.Objects.equals(freeCode6, that.freeCode6) &&
                java.util.Objects.equals(freeCode7, that.freeCode7) &&
                java.util.Objects.equals(freeCode8, that.freeCode8) &&
                java.util.Objects.equals(freeCode9, that.freeCode9) &&
                java.util.Objects.equals(freeCode10, that.freeCode10) &&
                java.util.Objects.equals(freeCode11, that.freeCode11) &&
                java.util.Objects.equals(freeCode12, that.freeCode12) &&
                java.util.Objects.equals(freeCode14, that.freeCode14) &&
                java.util.Objects.equals(freeCode15, that.freeCode15) &&
                java.util.Objects.equals(freeCode16, that.freeCode16) &&
                java.util.Objects.equals(freeCode17, that.freeCode17) &&
                java.util.Objects.equals(freeCode18, that.freeCode18) &&
                java.util.Objects.equals(freeCode19, that.freeCode19);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, orgId, organization, freeCode1, freeCode2, freeCode3, freeCode4, freeCode5, freeCode6, freeCode7, freeCode8, freeCode9, freeCode10, freeCode11, freeCode12, freeCode14, freeCode15, freeCode16, freeCode17, freeCode18, freeCode19);
    }
}
