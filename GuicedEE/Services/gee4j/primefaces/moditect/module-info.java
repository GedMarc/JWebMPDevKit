module primefaces {

	requires javax.faces;
	requires org.apache.commons.io;
	requires org.apache.commons.fileupload;
	requires java.servlet;
	requires javax.el;
	requires java.validation;

	requires static com.hazelcast.all;

	requires java.sql;
	requires java.scripting;
	requires java.desktop;
	requires static org.apache.poi;
	requires static org.apache.poi.ooxml;

	requires com.google.common;

	requires static itext;
	requires java.xml.bind;
	requires static barcode4j.light;
	requires static com.rometools.rome;
	requires static org.apache.xmlbeans;
	requires static encoder;
	requires static owasp.java.html.sanitizer;
	requires static esapi;
	requires org.json;
	requires static qrgen;

	requires org.apache.commons.lang3;
	requires static core;

	exports org.primefaces;
	exports org.primefaces.application;
	exports org.primefaces.application.exceptionhandler;
	exports org.primefaces.application.resource;
	exports org.primefaces.application.resource.barcode;
	exports org.primefaces.behavior.ajax;
	exports org.primefaces.behavior.base;
	exports org.primefaces.behavior.confirm;
	exports org.primefaces.behavior.printer;
	exports org.primefaces.behavior.validate;
	exports org.primefaces.cache;
	exports org.primefaces.component.accordionpanel;
	exports org.primefaces.component.ajaxexceptionhandler;
	exports org.primefaces.component.ajaxstatus;
	exports org.primefaces.component.api;
	exports org.primefaces.component.autocomplete;
	exports org.primefaces.component.barcode;
	exports org.primefaces.component.blockui;
	exports org.primefaces.component.breadcrumb;
	exports org.primefaces.component.button;
	exports org.primefaces.component.cache;
	exports org.primefaces.component.calendar;
	exports org.primefaces.component.captcha;
	exports org.primefaces.component.carousel;
	exports org.primefaces.component.celleditor;
	exports org.primefaces.component.chart;
	exports org.primefaces.component.chart.renderer;
	exports org.primefaces.component.checkbox;
	exports org.primefaces.component.clock;
	exports org.primefaces.component.collector;
	exports org.primefaces.component.colorpicker;
	exports org.primefaces.component.column;
	exports org.primefaces.component.column.renderer;
	exports org.primefaces.component.columngroup;
	exports org.primefaces.component.columns;
	exports org.primefaces.component.columntoggler;
	exports org.primefaces.component.commandbutton;
	exports org.primefaces.component.commandlink;
	exports org.primefaces.component.confirmdialog;
	exports org.primefaces.component.contentflow;
	exports org.primefaces.component.contextmenu;
	exports org.primefaces.component.dashboard;
	exports org.primefaces.component.datagrid;
	exports org.primefaces.component.datalist;
	exports org.primefaces.component.datascroller;
	exports org.primefaces.component.datatable;
	exports org.primefaces.component.datatable.feature;
	exports org.primefaces.component.defaultcommand;
	exports org.primefaces.component.diagram;
	exports org.primefaces.component.dialog;
	exports org.primefaces.component.dnd;
	exports org.primefaces.component.dock;
	exports org.primefaces.component.editor;
	exports org.primefaces.component.effect;
	exports org.primefaces.component.export;
	exports org.primefaces.component.feedreader;
	exports org.primefaces.component.fieldset;
	exports org.primefaces.component.filedownload;
	exports org.primefaces.component.fileupload;
	exports org.primefaces.component.focus;
	exports org.primefaces.component.fragment;
	exports org.primefaces.component.galleria;
	exports org.primefaces.component.gmap;
	exports org.primefaces.component.graphicimage;
	exports org.primefaces.component.growl;
	exports org.primefaces.component.hotkey;
	exports org.primefaces.component.idlemonitor;
	exports org.primefaces.component.imagecompare;
	exports org.primefaces.component.imagecropper;
	exports org.primefaces.component.imageswitch;
	exports org.primefaces.component.importconstants;
	exports org.primefaces.component.importenum;
	exports org.primefaces.component.inplace;
	exports org.primefaces.component.inputmask;
	exports org.primefaces.component.inputnumber;
	exports org.primefaces.component.inputswitch;
	exports org.primefaces.component.inputtext;
	exports org.primefaces.component.inputtextarea;
	exports org.primefaces.component.keyboard;
	exports org.primefaces.component.keyfilter;
	exports org.primefaces.component.knob;
	exports org.primefaces.component.layout;
	exports org.primefaces.component.lifecycle;
	exports org.primefaces.component.lightbox;
	exports org.primefaces.component.link;
	exports org.primefaces.component.log;
	exports org.primefaces.component.media;
	exports org.primefaces.component.media.player;
	exports org.primefaces.component.megamenu;
	exports org.primefaces.component.menu;
	exports org.primefaces.component.menubar;
	exports org.primefaces.component.menubutton;
	exports org.primefaces.component.menuitem;
	exports org.primefaces.component.message;
	exports org.primefaces.component.messages;
	exports org.primefaces.component.mindmap;
	exports org.primefaces.component.multiselectlistbox;
	exports org.primefaces.component.notificationbar;
	exports org.primefaces.component.orderlist;
	exports org.primefaces.component.outputlabel;
	exports org.primefaces.component.outputpanel;
	exports org.primefaces.component.overlaypanel;
	exports org.primefaces.component.paginator;
	exports org.primefaces.component.panel;
	exports org.primefaces.component.panelgrid;
	exports org.primefaces.component.panelmenu;
	exports org.primefaces.component.password;
	exports org.primefaces.component.photocam;
	exports org.primefaces.component.picklist;
	exports org.primefaces.component.poll;
	exports org.primefaces.component.progressbar;
	exports org.primefaces.component.radiobutton;
	exports org.primefaces.component.rating;
	exports org.primefaces.component.remotecommand;
	exports org.primefaces.component.repeat;
	exports org.primefaces.component.resetinput;
	exports org.primefaces.component.resizable;
	exports org.primefaces.component.ribbon;
	exports org.primefaces.component.ring;
	exports org.primefaces.component.row;
	exports org.primefaces.component.row.renderer;
	exports org.primefaces.component.roweditor;
	exports org.primefaces.component.rowexpansion;
	exports org.primefaces.component.rowtoggler;
	exports org.primefaces.component.schedule;
	exports org.primefaces.component.scrollpanel;
	exports org.primefaces.component.selectbooleanbutton;
	exports org.primefaces.component.selectbooleancheckbox;
	exports org.primefaces.component.selectcheckboxmenu;
	exports org.primefaces.component.selectmanybutton;
	exports org.primefaces.component.selectmanycheckbox;
	exports org.primefaces.component.selectmanymenu;
	exports org.primefaces.component.selectonebutton;
	exports org.primefaces.component.selectonelistbox;
	exports org.primefaces.component.selectonemenu;
	exports org.primefaces.component.selectoneradio;
	exports org.primefaces.component.separator;
	exports org.primefaces.component.signature;
	exports org.primefaces.component.slidemenu;
	exports org.primefaces.component.slider;
	exports org.primefaces.component.spacer;
	exports org.primefaces.component.spinner;
	exports org.primefaces.component.splitbutton;
	exports org.primefaces.component.spotlight;
	exports org.primefaces.component.stack;
	exports org.primefaces.component.steps;
	exports org.primefaces.component.sticky;
	exports org.primefaces.component.submenu;
	exports org.primefaces.component.subtable;
	exports org.primefaces.component.summaryrow;
	exports org.primefaces.component.tabmenu;
	exports org.primefaces.component.tabview;
	exports org.primefaces.component.tagcloud;
	exports org.primefaces.component.terminal;
	exports org.primefaces.component.themeswitcher;
	exports org.primefaces.component.tieredmenu;
	exports org.primefaces.component.timeline;
	exports org.primefaces.component.toolbar;
	exports org.primefaces.component.tooltip;
	exports org.primefaces.component.tree;
	exports org.primefaces.component.treetable;
	exports org.primefaces.component.watermark;
	exports org.primefaces.component.wizard;
	exports org.primefaces.config;
	exports org.primefaces.context;
	exports org.primefaces.convert;
	exports org.primefaces.el;
	exports org.primefaces.event;
	exports org.primefaces.event.data;
	exports org.primefaces.event.diagram;
	exports org.primefaces.event.map;
	exports org.primefaces.event.system;
	exports org.primefaces.event.timeline;
	exports org.primefaces.expression;
	exports org.primefaces.expression.impl;
	exports org.primefaces.facelets;
	exports org.primefaces.metadata;
	exports org.primefaces.metadata.transformer;
	exports org.primefaces.metadata.transformer.impl;
	exports org.primefaces.model;
	exports org.primefaces.model.chart;
	exports org.primefaces.model.diagram;
	exports org.primefaces.model.diagram.connector;
	exports org.primefaces.model.diagram.endpoint;
	exports org.primefaces.model.diagram.overlay;
	exports org.primefaces.model.filter;
	exports org.primefaces.model.map;
	exports org.primefaces.model.menu;
	exports org.primefaces.model.mindmap;
	exports org.primefaces.model.tagcloud;
	exports org.primefaces.model.timeline;
	exports org.primefaces.model.file;
	exports org.primefaces.model.terminal;
	exports org.primefaces.model.charts.pie;
	exports org.primefaces.model.charts.optionconfig.tooltip;
	exports org.primefaces.model.charts.optionconfig.title;
	exports org.primefaces.model.charts.polar;
	exports org.primefaces.model.charts.radar;
	exports org.primefaces.model.charts.scatter;
	exports org.primefaces.model.charts.optionconfig.legend;
	exports org.primefaces.model.charts.optionconfig.elements;
	exports org.primefaces.model.charts.line;
	exports org.primefaces.model.charts.hbar;
	exports org.primefaces.model.charts.donut;
	exports org.primefaces.model.charts.data;
	exports org.primefaces.model.charts.bubble;
	exports org.primefaces.model.charts.bar;
	exports org.primefaces.model.charts.axes.radial.linear;
	exports org.primefaces.model.charts.axes.radial;
	exports org.primefaces.model.charts.axes.cartesian.linear;
	exports org.primefaces.model.charts.axes.cartesian;
	exports org.primefaces.model.charts;
	exports org.primefaces.component.datatable.export;
	exports org.primefaces.component.autoupdate;
	exports org.primefaces.csp;
	exports org.primefaces.component.chips;
	exports org.primefaces.component.dataview;
	exports org.primefaces.component.headerrow;
	exports org.primefaces.component.linkbutton;
	exports org.primefaces.component.sidebar;
	exports org.primefaces.component.staticmessage;
	exports org.primefaces.component.texteditor;
	exports org.primefaces.component.toggleswitch;
	exports org.primefaces.component.tristatecheckbox;
	exports org.primefaces.component.barchart;
	exports org.primefaces.component.bubblechart;
	exports org.primefaces.component.donutchart;
	exports org.primefaces.component.linechart;
	exports org.primefaces.component.scatterchart;
	exports org.primefaces.component.piechart;
	exports org.primefaces.component.polarareachart;
	exports org.primefaces.component.radarchart;
	exports org.primefaces.component.datepicker;

	exports org.primefaces.component.organigram;
	exports org.primefaces.component.organigramnode;
	exports org.primefaces.event.organigram;

	exports org.primefaces.renderkit;
	exports org.primefaces.util;
	exports org.primefaces.validate;
	exports org.primefaces.validate.bean;
	exports org.primefaces.visit;
	exports org.primefaces.webapp;
	exports org.primefaces.webapp.filter;

	uses org.primefaces.component.fileupload.FileUploadDecoder;
}
