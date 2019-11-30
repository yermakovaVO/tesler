/*-
 * #%L
 * IO Tesler - API
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

package io.tesler.api.util.jackson.deser.convert;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;


public class Raw2StringDeserializer extends StdDeserializer<String> {

	public static final Raw2StringDeserializer INSTANCE = new Raw2StringDeserializer();

	public Raw2StringDeserializer() {
		super(String.class);
	}

	@Override
	public String deserialize(JsonParser parser, DeserializationContext ctx) throws IOException {
		return parser.getCodec().readTree(parser).toString();
	}

}