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


  var clients = Set(
    Client(5010255079763L, "Paperclips Large",
      "Large Plain Pack of 1000"),
    Client(5018206244666L, "Giant Paperclips",
      "Giant Plain 51mm 100 pack"),
    Client(5018306332812L, "Paperclip Giant Plain",
      "Giant Plain Pack of 10000"),
    Client(5018306312913L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018306312913L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5013306312913L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018206312913L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018336312913L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018304312913L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018306512913L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018306362913L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018306316913L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018306312613L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018306312963L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018306312917L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018306312912L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018306312113L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018306315913L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018306312913L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018306312913L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018306312913L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018306312913L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018306312913L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018306312913L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018306312913L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018306312913L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018306312913L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018306312913L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018306312913L, "No Tear Paper Clip",
      "No Tear Extra Large Pack of 1000"),
    Client(5018206244611L, "Zebra Paperclips",
      "Zebra Length 28mm Assorted 150 Pack")
  )

  def findAll = this.clients.toList.sortBy(_.ean)

  def findByEan(ean: Long) = this.clients.find(_.ean == ean)

  def save(client: Client) = {
    findByEan(client.ean).map( oldClient =>
      this.clients = this.clients - oldClient + client
    ).getOrElse(
        throw new IllegalArgumentException("Product not found")
      )
  }

}