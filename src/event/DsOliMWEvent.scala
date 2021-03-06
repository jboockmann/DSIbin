
/**
 *
 * Copyright (C) 2017 University of Bamberg, Software Technologies Research Group
 * <https://www.uni-bamberg.de/>, <http://www.swt-bamberg.de/>
 *
 * This file is part of the Data Structure Investigator (DSI) project, which received financial support by the
 * German Research Foundation (DFG) under grant no. LU 1748/4-1, see
 * <http://www.swt-bamberg.de/dsi/>.
 *
 * DSI is licensed under the GNU GENERAL PUBLIC LICENSE (Version 3), see
 * the LICENSE file at the project's top-level directory for details or consult <http://www.gnu.org/licenses/>.
 *
 * DSI is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or any later version.
 *
 * DSI is a RESEARCH PROTOTYPE and distributed WITHOUT ANY
 * WARRANTY, without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more
 * details.
 *
 * The following people contributed to the conception and realization of the present DSI distribution (in
 * alphabetic order by surname):
 *
 * - Jan H. Boockmann
 * - Gerald Lüttgen
 * - Thomas Rupprecht
 * - David H. White
 *
 */
 
 /**
 * @author DSI
 *
 * DsOliMWEvent.scala created on Sep 23, 2014
 *
 * Description: A memory write event
 */
package event

import scala.collection.mutable.ListBuffer

/**
 * @author DSI
 *
 */
/**
 * @constructor create a memory write event with a unique id and a source location
 * @param id unique id for an event
 * @param sourceLocation the location of the event in the source code
 * @param lValueList the target of the assignment (possibly contains more elements as the context is included as well)
 * @param rValue the value of the assignment
 * @param sourceAddress the address of the source vertex
 * @param sourceOffset the offset inside the source vertex
 */
class DsOliMWEvent(
  override val id: Int,
  override val sourceLocation: DsOliSourceLocation,
  val lValueList: ListBuffer[DsOliLValue],
  val rValue: DsOliRValue,
  val sourceAddress: Long,
  val sourceOffset: Long) extends DsOliMemoryEvent(id, sourceLocation) {

  override def toString(): String = {
    "[" + this.getClass() + "]" +
      "[id: " + this.id + "]" +
      "[sourceFile: " + this.sourceLocation.sourceFile + ", sourceLine: "
    +this.sourceLocation.sourceLine + ", sourceColumn: "
    +this.sourceLocation.sourceLineColumn + "]" +
      "[sourceAddres: " + this.sourceAddress.toHexString + ", sourceOffset: "
    +this.sourceOffset + ", targetAddress: " + this.rValue.content + "]"
  }
}