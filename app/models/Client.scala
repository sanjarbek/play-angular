package models

import play.api.libs.json._
import play.api.libs.functional.syntax._


case class Client(ean: Long, name: String, description: String)

object Client {

  implicit val clientWrites: Writes[Client] = (
    (JsPath \ "ean").write[Long] and
      (JsPath \ "name").write[String] and
      (JsPath \ "description").write[String]
    )(unlift(Client.unapply))

  implicit val clientReads: Reads[Client] = (
    (JsPath \ "ean").read[Long] and
      (JsPath \ "name").read[String] and
      (JsPath \ "description").read[String]
    )(Client.apply _)


  var clients = Set(
    Client(5010255079763L, "Paperclips Large",
      "Large Plain Pack of 1000"),
    Client(5018206244666L, "Giant Paperclips",
      "Giant Plain 51mm 100 pack"),
    Client(5018306332812L, "Paperclip Giant Plain",
      "Giant Plain Pack of 10000"),
    Client(5018306312913L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018206244611L, "Zebra Paperclips",
      "Zebra Length 28mm Assorted 150 Pack")
  )

  def findAll = this.clients.toList.sortBy(_.ean)

  def findByEan(ean: Long) = this.clients.find(_.ean == ean)

  def add(client: Client) = {
    clients += client
  }

  def save(client: Client) = {
    findByEan(client.ean).map( oldClient =>
      this.clients = this.clients - oldClient + client
    ).getOrElse(
        throw new IllegalArgumentException("Product not found")
      )
  }

}