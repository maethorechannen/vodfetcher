/*
 * Vodcasts.scala
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package vodfetcher.db

case class Vodcast(name: String, uri: String)

class Vodcasts {
    def all = {
        List(Vodcast("tekzilla", "http://revision3.com/tekzilla/feed/Quicktime-Large?subshow=false"))
    }
}
