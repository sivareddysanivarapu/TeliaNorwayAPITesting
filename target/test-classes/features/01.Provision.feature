Feature: Provision Subscription with Bundles

  @Provision @Drop1
  Scenario Outline: <TC> Provision of Subscription for <CRM> with <attribute> attributes
    Given Input Provision Request for <CRM> with <attribute> attributes
    When "Provision" API is called with <Validity> attributes
    Then Validate the "000" code, status and message in "Provision" output response
    
    Examples:
    	|TC   |attribute   |Validity |CRM      |
    	|TC001|"mandatory" |"Valid"  |"teliano"|
    	|TC002|"noOptional"|"Valid"  |"teliano"|
    	|TC035|"mandatory" |"Valid"  |"phonero"|
    	
  @Provision @Drop1
  Scenario Outline: <TC> Provision of Subscription with Invalid <function>
    Given Input Provision Request with invalid <function>
    When "Provision" API is called with <Validity> attributes
    Then Validate the <errorCode> code, status and message in "Provision" output response  
    
    Examples:
    	|TC   |function  |Validity      |errorCode|
    	|TC003|"dataType"|"Invalid"     |"ERR1000"|
    	|TC033|"bundle"  |"Non-existing"|"ERR2007"|
    
  @Provision @Drop1
  Scenario Outline: <TC> Provision with Missing mandatory <attribute>
    Given Input Request with missing mandatory <attribute>
    When "Provision" API is called with "Missing" attributes
    Then Validate the "ERR1001" code, status and message in "Provision" output response
    
    Examples:
    	|TC   |attribute          |
    	|TC004|"serviceIdentifier"|
    	|TC005|"IMSI"             |
    	|TC006|"subscriptionMode" |
    	|TC009|"customerType"     |
    	|TC011|"bdom"             |
    	|TC012|"billingFrequency" |
    	|TC015|"language"         |
    	|TC016|"serviceProviderID"|
    	|TC017|"subscriptionType" |

  @Provision @Drop1
  Scenario Outline: <TC> Provision with Length>15 for <attribute>
    Given Input Request with <attribute> Greater Length
    When "Provision" API is called with "Invalid" attributes
    Then Validate the "ERR1001" code, status and message in "Provision" output response
    
    Examples:
    	|TC   |attribute          |
    	|TC007|"serviceIdentifier"|
    	|TC008|"IMSI"             |
    	   
  @Provision @Drop1
  Scenario Outline: <TC> Provision with Invalid <attribute>
    Given Input Request with invalid <attribute>
    When "Provision" API is called with "Invalid" attributes
    Then Validate the "ERR1001" code, status and message in "Provision" output response
    
    Examples:
    	|TC   |attribute         |
    	|TC010|"M2MCustomerType" |
    	|TC013|"bdom"            |
    	|TC014|"emailAddress"    |
    	|TC022|"customerType"    |
    	|TC025|"subscriptionMode"|
                
  @Provision @Drop1
  Scenario Outline: <TC> Provision with Missing <attribute> notification
    Given Input Request with missing optional <attribute>
    When "Provision" API is called with "Valid" attributes
    Then Validate the "000" code, status and message in "Provision" output response
    
    Examples:
    	|TC   |attribute              |
    	|TC018|"domesticNotifyEnabled"|
    	|TC019|"rccNotifyEnabled"     |
    	|TC020|"roamingNotifyEnabled" |
    	|TC021|"barringTopupPurchase" |

  @Provision @PrimarySubscription @Drop1
  Scenario Outline: <TC> Provision with existing <attribute>
    Given Input Request with existing <attribute>
    When "Provision" API is called with "Existing" attributes
    Then Validate the <errorCode> code, status and message in "Provision" output response
    
    Examples:
    	|TC   |attribute          |errorCode|
    	|TC023|"serviceIdentifier"|"ERR3021"|
    	|TC024|"IMSI"             |"ERR3022"|
    	|TC034|"serviceIdentifier"|"ERR3021"|
    
  @Provision @Drop1
  Scenario Outline: <TC> Provision of Subscription with only <bundleType> Bundle
    Given Input Provision Request with only <bundleType> bundle
    When "Provision" API is called with <Validity> attributes
    Then Validate the <errorCode> code, status and message in "Provision" output response
    
    Examples:
    	|TC   |bundleType|errorCode|Validity |
    	|TC027|"Base"    |"000"    |"Valid"  |
    	|TC028|"Roaming" |"ERR1001"|"Missing"|
    	|TC029|"RCC"     |"ERR1001"|"Missing"|
    
  @Provision @Drop1
  Scenario Outline: <TC> Provision of Subscription <attribute> Bundle Group
    Given Input Provision Request <attribute> bundle group
    When "Provision" API is called with <Validity> attributes
    Then Validate the <errorCode> code, status and message in "Provision" output response
    
    Examples:
    	|TC   |attribute|errorCode|Validity |
    	|TC030|"with"   |"000"    |"Valid"  |
    	|TC031|"without"|"ERR1001"|"Missing"|
    
  @Provision @Drop1
  Scenario Outline: <TC> Provision of Subscription for <CRM> with <Validity> BDOM
    Given Input Provision Request for <CRM> with <Validity> BDOM
    When "Provision" API is called with <Validity> attributes
    Then Validate the <errorCode> code, status and message in "Provision" output response
    
    Examples:
    	|TC   |CRM      |Validity |errorCode|
    	|TC036|"teliano"|"Valid"  |"000"    |
    	|TC037|"teliano"|"Invalid"|"ERR1001"|
    	|TC042|"phonero"|"Valid"  |"000"    |
    	|TC043|"phonero"|"Invalid"|"ERR1001"|
    
  @Provision @Drop1
  Scenario Outline: <TC> Provision of Subscription <attribute> notificationPrice for Phonero
    Given Input Provision Request <attribute> notificationPrice for Phonero
    When "Provision" API is called with "Valid" attributes
    Then Validate the "000" code, status and message in "Provision" output response
    
    Examples:
    	|TC   |attribute|
    	|TC038|"with"   |
    	|TC039|"without"|
    
  @Provision @Drop1
  Scenario Outline: <TC> Provision of Subscription by providing channel as <attribute>
    Given Input Provision Request with channel as <attribute>
    When "Provision" API is called with "Valid" attributes
    Then Validate the "000" code, status and message in "Provision" output response
    
    Examples:
    	|TC   |attribute|
    	|TC040|"SMS"    |
    	|TC041|"Email"  |
    
  @Provision @Drop1
  Scenario Outline: <TC> Provision of Subscription with billingFrequency as <billingModel>
    Given Input Provision Request with billingFrequency as <billingModel>
    When "Provision" API is called with <Validity> attributes
    Then Validate the <errorCode> code, status and message in "Provision" output response
    
    Examples:
    	|TC   |billingModel|errorCode|Validity |
    	|TC044|"Monthly"   |"000"    |"Valid"  |
    	|TC045|"Quarterly" |"ERR1001"|"Invalid"|
    
  @Provision @Drop1
  Scenario Outline: <TC> Provision of Subscription without channel and <attribute>
    Given Input Provision Request without channel and <attribute>
    When "Provision" API is called with <Validity> attributes
    Then Validate the <errorCode> code, status and message in "Provision" output response
    
    Examples:
    	|TC   |attribute        |errorCode|Validity |
    	|TC046|"emailAddress"   |"000"    |"Valid"  |
    	|TC047|"alternateNumber"|"ERR1001"|"Missing"|
    
  @Provision @Drop1
  Scenario Outline: <TC> Provision of Prepaid Subscription without IMSI and <attribute>
    Given Input Provision Request without IMSI and <attribute>
    When "Provision" API is called with "Valid" attributes
    Then Validate the "000" code, status and message in "Provision" output response
    
    Examples:
    	|TC   |attribute         |
    	|TC032|"optional fields" |
    	|TC048|"bdom"            |
    	|TC049|"billingFrequency"|
    	|TC050|"language"        |