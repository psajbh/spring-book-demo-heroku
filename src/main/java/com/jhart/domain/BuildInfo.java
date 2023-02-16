package com.jhart.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "git_info")
public class BuildInfo implements IEntity, Serializable{

	private static final long serialVersionUID = -5948181498794633533L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@Column(name = "branch", nullable = false, columnDefinition = "varchar(20)")
	private String branch;
	
	@Column(name = "build_host", nullable = false, columnDefinition = "varchar(50)")
	private String host;
	
	@Column(name = "build_version", nullable = false, columnDefinition = "varchar(20)")
	private String version;
	
	@Column(name = "commit_time", nullable = false, columnDefinition = "varchar(25)")
	private String commitTime;

	@Column(name = "commit_id_short", nullable = false, columnDefinition = "varchar(10)")
	private String commitIdShort;
	
	@Column(name = "commit_id_long", nullable = false, columnDefinition = "varchar(42)")
	private String commitIdLong;

	@Column(name = "commit_msg_short", nullable = false, columnDefinition = "varchar(150)")
	private String commitMsg;

	@Column(name = "remote_origin_url", nullable = false, columnDefinition = "varchar(150)")
	private String originUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}



	public String getCommitMsg() {
		return commitMsg;
	}

	public void setCommitMsg(String commitMsg) {
		this.commitMsg = commitMsg;
	}

	public String getCommitTime() {
		return commitTime;
	}

	public void setCommitTime(String commitTime) {
		this.commitTime = commitTime;
	}

	public String getOriginUrl() {
		return originUrl;
	}

	public void setOriginUrl(String originUrl) {
		this.originUrl = originUrl;
	}

	public String getCommitIdShort() {
		return commitIdShort;
	}

	public void setCommitIdShort(String commitIdShort) {
		this.commitIdShort = commitIdShort;
	}

	public String getCommitIdLong() {
		return commitIdLong;
	}

	public void setCommitIdLong(String commitIdLong) {
		this.commitIdLong = commitIdLong;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result + ((commitMsg == null) ? 0 : commitMsg.hashCode());
		result = prime * result + ((commitTime == null) ? 0 : commitTime.hashCode());
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + ((originUrl == null) ? 0 : originUrl.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BuildInfo other = (BuildInfo) obj;
		if (branch == null) {
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
			return false;
		if (commitMsg == null) {
			if (other.commitMsg != null)
				return false;
		} else if (!commitMsg.equals(other.commitMsg))
			return false;
		if (commitTime == null) {
			if (other.commitTime != null)
				return false;
		} else if (!commitTime.equals(other.commitTime))
			return false;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (originUrl == null) {
			if (other.originUrl != null)
				return false;
		} else if (!originUrl.equals(other.originUrl))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}


}
