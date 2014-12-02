Implementing a System Highlighting a Non-Trivial Modern Architecture Project
CS 575 - Fall 2014
Justin Weaver
==============================================================================

This is the final project for class CS 575 for the Fall of 2014. 

Project Description: 

This project is an implementation of a medical web portal for a generic doctor's office. It's mainly geared towards
patients and doctors allowing for the booking, cancellation and creation of appointments, checking of billing information and payment as well as patient request for prescription refills and doctor approvals of those requests. There are two web services that are included as well. The Patient Billining Information web service exposes data that an external payment processing company can access to bill and receive payments from patients. The Prescription web service exposes information for approved prescription refills so they can access and fulfill those requests.

This project uses many modern design features. It is implemented using the Java EE 7 web framework. It uses many modern concepts
including Java Server Faces, Java Persistance API, EBJs and Java Web Services. 

Running the Software:

The project is implemented as Maven Web Application project. To run this project, you can simply down this repository, unzip, import to your 
favorite Java EE enabled IDE, import the project to the IDE, build and deploy to your Java EE web container. 

If you do not wish to use an IDE, you may also download Maven and a Java EE compliant web container and build and deploy manually.
