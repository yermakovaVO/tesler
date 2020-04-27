/*-
 * #%L
 * IO Tesler - Core
 * %%
 * Copyright (C) 2018 - 2019 Tesler Contributors
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

package io.tesler.core.ui.field;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.tesler.core.ui.model.json.field.FieldMeta;
import java.io.IOException;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

//TODO This test needs work
class PackageScanFieldIdResolverTest {

	@Mock
	JavaType baseType;

	@Mock
	Map<String, JavaType> typeMap;

	@InjectMocks
	PackageScanFieldIdResolver packageScanFieldIdResolver;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(packageScanFieldIdResolver, "includePackages", new String[0]);
		ReflectionTestUtils.setField(packageScanFieldIdResolver, "excludeClasses", new String[0]);
	}

	@Test
	void testInit() {
		packageScanFieldIdResolver.init(baseType);
	}

	@Test
	void testFailedInit() {
		String[] value = {"io.tesler.core.ui.field"};
		baseType = new ObjectMapper().getTypeFactory().constructType(FieldMeta.class);
		ReflectionTestUtils.setField(packageScanFieldIdResolver, "includePackages", value);
		assertThrows(IllegalStateException.class, () -> packageScanFieldIdResolver.init(baseType));
	}

	@Test
	void testIdFromValue() {
		String result = packageScanFieldIdResolver.idFromValue("o");
		Assertions.assertEquals(null, result);
	}

	@Test
	void testIdFromBaseType() {
		String result = packageScanFieldIdResolver.idFromBaseType();
		Assertions.assertEquals(null, result);
	}

	@Test
	void testIdFromValueAndType() {
		String result = packageScanFieldIdResolver.idFromValueAndType("o", null);
		Assertions.assertEquals(null, result);
	}

	@Test
	void testTypeFromId() {
		assertThrows(IOException.class, () -> packageScanFieldIdResolver.typeFromId(null, "someFakeClasss"));
	}

	@Test
	void testGetDescForKnownTypeIds() {
		String result = packageScanFieldIdResolver.getDescForKnownTypeIds();
		Assertions.assertEquals(null, result);
	}

	@Test
	void testGetMechanism() {
		Id result = packageScanFieldIdResolver.getMechanism();
		Assertions.assertEquals(Id.CUSTOM, result);
	}

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme