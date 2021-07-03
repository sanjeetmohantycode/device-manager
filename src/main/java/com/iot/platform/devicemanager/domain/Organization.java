package com.iot.platform.devicemanager.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name = "organization", catalog = "org details")
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Organization {

    @Id
    private String id;

    private String orgId;

    private String orgName;

    private String orgDescription;

    private Boolean status;

    private String imageUrl;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true, orphanRemoval = true)
    @JoinColumn(name = "orgdetail_id")
    private OrganizationDetail organizationDetail;


    @Override
    public String toString() {
        return "Organization{" + "id='" + id + "'," + "orgId='" + orgId + "'," + "orgName='" + orgName + "'," + "orgDescription='" + orgDescription + "'," + "status='" + status + "'," + "imageUrl='" + imageUrl + "'," + "organizationDetail='" + organizationDetail + "'" + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return java.util.Objects.equals(id, that.id) &&
                java.util.Objects.equals(orgId, that.orgId) &&
                java.util.Objects.equals(orgName, that.orgName) &&
                java.util.Objects.equals(orgDescription, that.orgDescription) &&
                java.util.Objects.equals(status, that.status) &&
                java.util.Objects.equals(imageUrl, that.imageUrl) &&
                java.util.Objects.equals(organizationDetail, that.organizationDetail);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, orgId, orgName, orgDescription, status, imageUrl, organizationDetail);
    }
}
