/*
 * Copyright © 2015 Stefan Niederhauser (nidin@gmx.ch)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package guru.nidi.graphviz

import guru.nidi.graphviz.attribute.Arrow
import guru.nidi.graphviz.attribute.Color
import guru.nidi.graphviz.engine.Format.PNG
import guru.nidi.graphviz.engine.Graphviz
import guru.nidi.graphviz.model.*
import guru.nidi.graphviz.model.Compass.SOUTH
import org.junit.jupiter.api.Test
import java.io.File

class KraphvizTest {
    @Test
    fun simple() {
        val g = graph(directed = true) {
            edge["color" eq "red"]
            edge[Arrow.TEE]
            node[Color.GREEN]
            graph[Color.GREY.background()]

            "g".link("h")
            "i" link "j"
            "e" - "f"

            ("a"[Color.RED] - "b")[Arrow.VEE]
            "c" / "rec" / SOUTH - "d"
        }
        println(g)
        Graphviz.fromGraph(g).render(PNG).toFile(File("target/kt1.png"))
    }
}
