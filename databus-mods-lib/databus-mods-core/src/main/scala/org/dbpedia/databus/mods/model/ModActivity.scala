package org.dbpedia.databus.mods.model

import java.util.concurrent.Callable

trait ModActivity extends Callable[ModActivityMetadata] {

  override def call(): ModActivityMetadata = {

//    val mam = ModMetadataFactory.createModActivityMetadata()

    // version

    // used

    // start

    // end

    // onlineRate

    // generated


/*
6 <activity.ttl> a mod:OnlineCheckMod ;
7 mod:version "1.0.0" ;
8 prov:used n0:demo-graph\/20210301\/demo-graph.png ;
9 prov:startedAtTime "2021-04-15T12:05:36.384Z"^^xsd:#dateTime ;
10 prov:endedAtTime "2021-04-15T12:05:36.851Z"^^xsd:dateTime ;
11 mod:onlineRate "100%"^^xsd:string ;
12 prov:generated <online.csv> ;
13 prov:generated <online.svg> .
14
15 <online.svg> mod:svgDerivedFrom n0:demo-graph\/20210301\/demo-graph.png .
16 <online.csv> mod:csvDerivedFrom n0:demo-graph\/20210301\/demo-graph.png .

7 <activity.ttl> a mod:DatabusMod ;
8 mod:version "4fc1d36f833093b241036d94b307a20aac827140" ;
9 prov:used g0:demo-graph\/20210301\/demo-graph.ttl ;
10 prov:startedAtTime "2021-04-15T12:04:22.384Z"^^xsd:#dateTime ;
11 prov:endedAtTime "2021-04-15T12:04:22.851Z"^^xsd:dateTime ;
12 prov:generated <mimetype.ttl> .
13
14 <mimetype.ttl>
15 mod:enrichmentDerivedFrom g0:demo-graph\/20210301\/demo-graph.ttl.gz .
16
17 # content of mimetype.ttl
18 @prefix dcat: <http://www.w3.org/ns/dcat#> .
19
20 g0:demo-graph\/20210301\/demo-graph.ttl
21 dcat:mediaType <http://dataid.dbpedia.org/ns/iana#text/turtle> .
22 dcat:compression <ttp://dataid.dbpedia.org/ns/mt#gz> .
 */
   null
  }
}
