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

package io.tesler.core.ui.model.json.field.subtypes;

import io.tesler.core.ui.field.TeslerWidgetField;
import io.tesler.core.ui.model.json.field.FieldMeta.FieldMetaBase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@TeslerWidgetField({"number", "money", "percent"})
public class NumberFieldMeta extends FieldMetaBase {

	private Long digits;

	private Boolean nullable;

}
