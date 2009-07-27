/*
 * Vodcatcher.scala
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package vodfetcher

import vodfetcher.db._

import java.net.URL

import com.sun.syndication.io.SyndFeedInput
import com.sun.syndication.io.XmlReader
import com.sun.syndication.feed.synd._

class Vodfetcher {
    val vodcasts = new Vodcasts
    def fetchAll() = {
        val dtracker = new DownloadTracker
        vodcasts.all.foreach { cast =>
            val url = new URL(cast.uri)
            val inp = new SyndFeedInput
            val feed = inp.build(new XmlReader(url))
            dtracker.getNewEnclosures(feed).foreach { enc =>
                
            }
        }
    }

    def downloadEnclosure(enc: SyndEnclosure) = {
        
    }

}
