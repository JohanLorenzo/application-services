/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mozilla.appservices.logins
import org.json.JSONArray
import org.json.JSONObject

/**
 * Raw import phase metrics data that is stored by the LoginsStorage implementation.
 */
data class ImportPhaseMetrics(

    /**
     * Name of the import phase
     */
    val name: String,

    /**
     * Number of records at the beginning of the import phase
     */
    val totalStarting: Int,

    /**
     * Number of records successfully processed during the import phase
     */
    val totalSuccessfullyProcessed: Int,

    /**
     * Total duration of the import phase in ms
     */
    val totalDuration: Int,

    /**
     * List of errors encountered during the import phase
     */
    val errors: List<String>
) {
    fun toJSON(): JSONObject {
        val o = JSONObject()
        o.put("name", name)
        o.put("totalStarting", totalStarting)
        o.put("totalSuccessfullyProcessed", totalSuccessfullyProcessed)
        o.put("totalDuration", totalDuration)
        o.put("errors", JSONArray(errors))
        return o
    }

    companion object {
        fun fromJSON(jsonObject: JSONObject): ImportPhaseMetrics {
            val errorsList: MutableList<String> = mutableListOf()
            val errorsArray = jsonObject.getJSONArray("errors")
            for (index in 0 until errorsArray.length())  {
                errorsList.add(errorsArray.getString(index))
            }

            return ImportPhaseMetrics(
                name = jsonObject.getString("name"),
                totalStarting = jsonObject.getInt("totalStarting"),
                totalSuccessfullyProcessed = jsonObject.getInt("totalSuccessfullyProcessed"),
                totalDuration = jsonObject.getInt("totalDuration"),
                errors = errorsList
            )
        }

        fun fromJSON(jsonText: String): ImportPhaseMetrics {
            return fromJSON(JSONObject(jsonText))
        }

        fun fromJSONArray(jsonArrayText: String): List<ImportPhaseMetrics> {
            val result: MutableList<ImportPhaseMetrics> = mutableListOf()
            val array = JSONArray(jsonArrayText)
            for (index in 0 until array.length()) {
                result.add(fromJSON(array.getJSONObject(index)))
            }
            return result
        }
    }
}
