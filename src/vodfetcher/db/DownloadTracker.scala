/*
 * DownloadTracker.scala
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package vodfetcher.db

import vodfetcher.rome.Sugar._

import com.sun.syndication.feed.synd._
import scala.collection.mutable.ListBuffer

class DownloadTracker {
    /**
    *   Take a feed and return a list of new enclosures
    */
    def getNewEnclosures(feed: SyndFeed): List[SyndEnclosure] = {
        val entries = feed.entries
        var newEncs = new ListBuffer[SyndEnclosure]
        entries.foreach { entry =>
            entry.enclosures.foreach { enclosure =>
                newEncs.append(enclosure)
            }
        }
        newEncs.toList
    }
}
