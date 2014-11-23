---
layout: post
author: Uli Heller
published: true
title: "Markdown-Testdokument"
date: 2012-05-18 08:00
updated: 2012-11-27 07:00
comments: true
categories: 
- Blog
- Octopress
- Markdown
---

Markdown-Testdokument
=====================

Dies ist mein Testdokument für Markdown. Ich packe hier einfach alle denkbaren Konstrukte in Markdown rein, damit ich nicht immer wieder neu suchen muß.

<!-- more -->

Quellen:

* [DaringFireball](http://daringfireball.net/projects/markdown/) - (besser lesbare lokale [Kopie]({{ root_url }}/articles/daringfireball-markdown.html) davon)

Überschrift
-----------

Noch eine Überschrift
---------------------

### Abschnitt 1 ###

### Abschnitt 2 ###

* Eine Liste
    * Geschachtelte Liste
* Formatierungen
    * _fett_
    * *fett*
    * __fett__
    * **fett**
    * Kommando: `ls -l`
* Liste mit Code-Block:
        cd /tmp
        ls

Ein Bild: ![CC-Icon](/images/cc-by-sa-3.0_88x31.png)

Octopress-Erweiterungen
-----------------------

### Codeblock

{% codeblock Here's an example .rvmrc file. lang:ruby %}
rvm ruby-1.8.6 # ZOMG, seriously? We still use this version?
{% endcodeblock %}

Nach gegenwärtigem Kenntnisstand kann so ein Codeblock nicht Bestandteil einer Liste sein! (Octopress-2.0 und 2.1)

### Datei

{% include_code Beispiel.java %}

### Bild

{% img /images/cc-by-sa-3.0_88x31.png 'CC-Icon' %}

Tests
-----

### Liste mit Codeblock

* Liste
* mit Codeblock
    {% codeblock Here's an example .rvmrc file. lang:ruby %}
    rvm ruby-1.8.6 # ZOMG, seriously? We still use this version?
    {% endcodeblock %}
