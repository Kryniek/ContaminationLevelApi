package pl.kryniek.contamination.level.api.ContaminationLevel.enums;

import static java.util.Objects.isNull;

public enum InstallationId {
	// @formatter:off
	WEJHEROWO_SOBIESKIEGO(6230),
	WEJHEROWO_SKARGI(3351);
	// @formatter:on

	private Integer id;

	private InstallationId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public static InstallationId parse(Integer id) {
		if (isNull(id) || Integer.compare(id.intValue(), 0) <= 0) {
			return null;
		}

		for (InstallationId instalationId : InstallationId.values()) {
			if (instalationId.getId().equals(id)) {
				return instalationId;
			}
		}

		throw new RuntimeException("Cannot parse InstallationId with id: " + id + ".");
	}
}
