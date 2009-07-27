/*
 * Sugar.scala
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package vodfetcher.rome

import com.sun.syndication.feed.synd._

object Sugar {
    implicit def feedEntriesWrapper(feed: SyndFeed): {def entries: List[SyndEntry]} = {
        class entryWrapper(feed: SyndFeed) {
            def entries: List[SyndEntry] = {
                val es = feed.getEntries().asInstanceOf[java.util.List[SyndEntry]]
                val ses = scala.collection.jcl.Conversions.convertList[SyndEntry](es)
                ses.toList
            }
        }
        return new entryWrapper(feed)
    }

    implicit def entryEnclosuresWrapper(entry: SyndEntry): {def enclosures: List[SyndEnclosure]} = {
        class EnclosuresWrapper(entry: SyndEntry) {
            def enclosures: List[SyndEnclosure] = {
                val es = entry.getEnclosures().asInstanceOf[java.util.List[SyndEnclosure]]
                val ses = scala.collection.jcl.Conversions.convertList[SyndEnclosure](es)
                ses.toList
            }
        }
        return new EnclosuresWrapper(entry)
    }
}
