package com.study.recommendation;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RecommendationApplicationTests {

	class Version {
		private Long id;
		private String version;

		Version (Long id,String version) {
			this.id = id;
			this.version = version;

		};
		public Long getId() {
			return id;
		}
		public String getVersion() {
			return version;
		}
	}

	private int compare(Version version, Version version2) {
		List<String> beforeVersionList = Arrays.asList(version.getVersion().split(","));
		List<String> afterVersionList = Arrays.asList(version2.getVersion().split(","));
		int versionMaxLen = Math.max(beforeVersionList.size(), afterVersionList.size());
		for (int i = 0; i < versionMaxLen; i++) {
			String token = Optional.of(beforeVersionList.get(i)).orElse("");
			String token2 = Optional.of(afterVersionList.get(i)).orElse("");
			int com = token2.compareTo(token);
			if (com != 0) {
				return com;
			}
		}
		return 0;
	}

	@Test
	void test() {
		Version version1 = new Version(1L,"1.0.1");
		Version version2 = new Version(2L,"2.1.1");
		Version version3 = new Version(3L,"1.10.1");
		Version version4 = new Version(4L,"1.0.1");
		Version version5 = new Version(4L,"1.0");

		List<Version> list = Arrays.asList(version1, version2, version3,version4,version5);
		//1
		String lastVersion = list.stream().sorted(this::compare).findFirst().get().getVersion();
		//2
		String lastVersion2 = list.stream().sorted(Comparator.comparing(Version::getVersion)).findFirst().get().getVersion();
		Collections.sort(list,(before,next) -> before.getVersion().compareTo(next.getVersion()));

		assertThat(lastVersion).isEqualTo("2.1.1");
		assertThat(list.get(0).getVersion()).isEqualTo("2.1.1");
		assertThat(lastVersion2).isEqualTo("2.1.1");
	}

}
