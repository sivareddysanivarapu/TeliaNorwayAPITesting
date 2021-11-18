Feature: Provision Subscription with Bundles

  @Provision
  Scenario: TC_001 Provision of Subscription with only Base Bundle
    Given Input Provision Request with mandatory attributes
    When "Provision" API is called
    Then Validate the "000" code and status in "Provision" output response
    
  
  Scenario: TC_002 Provision of Subscription without optional fields
    Given Input Provision Request without optional fields
    When "Provision" API is called
    Then Validate the "000" code and status in "Provision" output response
    
  @Provision
  Scenario: TC_003 Provision of Subscription with Invalid DataType
    Given Input Provision Request with invalid dataType
    When "Provision" API is called with invalidDataType
    Then Validate the "ERR1000" code , invalid status and message in output response  
    
  @Provision
  Scenario: TC_004 Provision with Missing Service Identifier
    Given Input Request with missing serviceIdentifier
    When "Provision" API is called with missing attributes
    Then Validate the "ERR1001" code , status, message and error message in output response

  @Provision
  Scenario: TC_005 Provision with Missing IMSI
    Given Input Request with missingIMSI
    When "Provision" API is called with missing attributes
    Then Validate the "ERR1001" code , status, message and error message in output response
    
  @Provision
  Scenario: TC_006 Provision with Missing Subscription Mode
    Given Input Request with missingSubscriptionMode
    When "Provision" API is called with missing attributes
    Then Validate the "ERR1001" code , status, message and error message in output response   
    
  @Provision
  Scenario: TC_007 Provision with Service Identifier (Length>15)
    Given Input Request with Service Identifier Greater Length
    When "Provision" API is called with invalid values
    Then Validate the "ERR1001" code , status, message and error message in output response
    
  @Provision
  Scenario: TC_008 Provision with IMSI (Length>15)
    Given Input Request with IMSI Greater Length
    When "Provision" API is called with invalid values
    Then Validate the "ERR1001" code , status, message and error message in output response
    
  @Provision
  Scenario: TC_009 Provision with Mising Account(customerType) Attribute
    Given Input Request with missing customerType attribute
    When "Provision" API is called with missing attributes
    Then Validate the "ERR1001" code , status, message and error message in output response
  
  @Provision
  Scenario: TC_010 Provision with M2M Account(customerType) Attribute
    Given Input Request with M2M customerType
    When "Provision" API is called with invalid values
    Then Validate the "ERR1001" code , status, message and error message in output response
    
  @Provision
  Scenario: TC_011 Provision with Mising Account(bdom) Attribute
    Given Input Request with missing bdom attribute
    When "Provision" API is called with missing attributes
    Then Validate the "ERR1001" code , status, message and error message in output response
    
  @Provision
  Scenario: TC_012 Provision with Mising Account(billingFrequency) Attribute
    Given Input Request with missing billingFrequency attribute
    When "Provision" API is called with missing attributes
    Then Validate the "ERR1001" code , status, message and error message in output response
    
  @Provision
  Scenario: TC_013 Provision with Invalid BDOM
    Given Input Request with invalid bdom
    When "Provision" API is called with invalid values
    Then Validate the "ERR1001" code , status, message and error message in output response
        
  @Provision
  Scenario: TC_014 Provision with Invalid Email Address
    Given Input Request with invalid emailAddress
    When "Provision" API is called with invalid values
    Then Validate the "ERR1001" code , status, message and error message in output response
      
  @Provision
  Scenario: TC_015 Provision with Mising Preferences(Language) Attribute
    Given Input Request with missing language attribute
    When "Provision" API is called with missing attributes
    Then Validate the "ERR1001" code , status, message and error message in output response
    
  @Provision
  Scenario: TC_016 Provision with Mising Preferences(Service Provider ID) Attribute
    Given Input Request with missing serviceProvideID attribute
    When "Provision" API is called with missing attributes
    Then Validate the "ERR1001" code , status, message and error message in output response
  
  @Provision
  Scenario: TC_017 Provision with Mising Preferences(Subscription Type) Attribute
    Given Input Request with missing subscriptionType attribute
    When "Provision" API is called with missing attributes
    Then Validate the "ERR1001" code , status, message and error message in output response
      
  @Provision
  Scenario: TC_018 Provision with Mising Notificatios(domesticNotifyEnabled) Attribute
    Given Input Request with missing domesticNotifyEnabled attribute
    When "Provision" API is called
    Then Validate the "000" code and status in "Provision" output response

  @Provision
  Scenario: TC_019 Provision with Mising Notificatios(RCCNotifyEnabled) Attribute
    Given Input Request with missing RCCNotifyEnabled attribute
    When "Provision" API is called
    Then Validate the "000" code and status in "Provision" output response
    
  @Provision
  Scenario: TC_020 Provision with Mising Notificatios(baringTopupPurchase) Attribute
    Given Input Request with missing baringTopupPurchase attribute
    When "Provision" API is called
    Then Validate the "000" code and status in "Provision" output response
    
  @Provision
  Scenario: TC_021 Provision with Mising Notificatios(roamingNotifyEnabled) Attribute
    Given Input Request with missing roamingNotifyEnabled attribute
    When "Provision" API is called
    Then Validate the "000" code and status in "Provision" output response
    
  @Provision
  Scenario: TC_022 Provision with Invalid Customer Type
    Given Input Request with invalid customerType
    When "Provision" API is called with invalid values
    Then Validate the "ERR1001" code , status, message and error message in output response
    
  @Provision @PrimarySubscription
  Scenario: TC_023 Provision with Existing Service Identifier
    Given Input Request with existing serviceIdentifier
    When "Provision" API is called with existing values
    Then Validate the "ERR3021" code , status and message in output response
    
  @Provision @PrimarySubscription
  Scenario: TC_024 Provision with Existing IMSI
    Given Input Request with existing IMSI
    When "Provision" API is called with existing values
    Then Validate the "ERR3022" code , status and message in output response
    
  @Provision
  Scenario: TC_025 Provision with Invalid Subscription Mode
    Given Input Request with invalid subscriptionMode
    When "Provision" API is called with invalid values
    Then Validate the "ERR1001" code , status, message and error message in output response
    
  @Provision @Test
  Scenario: TC_026 Provision Service Enrichment
    Given Service Enrichment
    
  