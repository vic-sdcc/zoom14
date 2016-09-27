/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mis
 */
@Entity
@Table(name = "coop_app_mat_evaluation")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CoopAppMatEvaluation.findAll", query = "SELECT c FROM CoopAppMatEvaluation c"),
	@NamedQuery(name = "CoopAppMatEvaluation.findByMatEvaluationNo", query = "SELECT c FROM CoopAppMatEvaluation c WHERE c.matEvaluationNo = :matEvaluationNo"),
	@NamedQuery(name = "CoopAppMatEvaluation.findByEvaluationSched", query = "SELECT c FROM CoopAppMatEvaluation c WHERE c.evaluationSched = :evaluationSched")})
public class CoopAppMatEvaluation implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mat_evaluation_no")
	private Integer matEvaluationNo;
	@Column(name = "evaluation_sched")
    @Temporal(TemporalType.DATE)
	private Date evaluationSched;
	@JoinColumn(name = "inv_no", referencedColumnName = "inv_no")
    @ManyToOne
	private CoopEducMaterial invNo;
	@JoinColumn(name = "applicant_no", referencedColumnName = "applicant_no")
    @ManyToOne
	private CoopApplicant applicantNo;

	public CoopAppMatEvaluation() {
	}

	public CoopAppMatEvaluation(Integer matEvaluationNo) {
		this.matEvaluationNo = matEvaluationNo;
	}

	public Integer getMatEvaluationNo() {
		return matEvaluationNo;
	}

	public void setMatEvaluationNo(Integer matEvaluationNo) {
		this.matEvaluationNo = matEvaluationNo;
	}

	public Date getEvaluationSched() {
		return evaluationSched;
	}

	public void setEvaluationSched(Date evaluationSched) {
		this.evaluationSched = evaluationSched;
	}

	public CoopEducMaterial getInvNo() {
		return invNo;
	}

	public void setInvNo(CoopEducMaterial invNo) {
		this.invNo = invNo;
	}

	public CoopApplicant getApplicantNo() {
		return applicantNo;
	}

	public void setApplicantNo(CoopApplicant applicantNo) {
		this.applicantNo = applicantNo;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (matEvaluationNo != null ? matEvaluationNo.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CoopAppMatEvaluation)) {
			return false;
		}
		CoopAppMatEvaluation other = (CoopAppMatEvaluation) object;
		if ((this.matEvaluationNo == null && other.matEvaluationNo != null) || (this.matEvaluationNo != null && !this.matEvaluationNo.equals(other.matEvaluationNo))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.CoopAppMatEvaluation[ matEvaluationNo=" + matEvaluationNo + " ]";
	}
	
}
