/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mozilla.appservices.logins
// import org.json.JSONArray
// import org.json.JSONException
// import org.json.JSONObject

/**
 * Raw password data that is stored by the LoginsStorage implementation.
 */
data class ImportMetrics(

    /**
     * Total duration of the import in ms
     */
   val totalDuration: Int,

    /**
     * List of metrics for each import phase
     */
    val phases: List<ImportPhaseMetrics>,

    /**
     * Number of records that failed during the import
     */
    val numFailed: Int,

    /**
     * List of errors encountered during the import
     */
    val errors: List<String>
) {

    fun toJSON(): JSONObject {
        val o = JSONObject()
        o.put("totalDuration", totalDuration)
        o.put("phases", phases.toJSON())
        o.put("numFailed", numFailed)
        o.put("errors", new JSONArray(errors))
        return o
    }

    // TODO: create JSON static methods
}
