package com.shared.oauth.enums;



public enum ErrorEnum {
    // Common Errors
    DUPLICATE_ENTRY("GEN001", "Duplicate request data", HttpStatus.BAD_REQUEST),
    INVALID_INPUT("GEN002", "Invalid request data", HttpStatus.BAD_REQUEST),
    DATABASE_OPERATION_FAILED("GEN003", "Database operation failed", HttpStatus.BAD_REQUEST),



    INVALID_REQUEST("ERR001", "Invalid request data", HttpStatus.BAD_REQUEST),
    ENTITY_NOT_FOUND("ERR002", "Entity not found", HttpStatus.NOT_FOUND),
    INTERNAL_SERVER_ERROR("ERR003", "Internal server error", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST("ERR004", "Invalid request parameters", HttpStatus.BAD_REQUEST),

    // Brand-Specific Errors
    BRAND_ALREADY_EXISTS("BRD001", "Brand already exists with this name", HttpStatus.CONFLICT),
    BRAND_NOT_FOUND("BRD002", "Brand not found with the provided ID", HttpStatus.NOT_FOUND),
    BRAND_LIST_EMPTY("BRD003", "Brand list cannot be null or empty", HttpStatus.BAD_REQUEST),
    BRAND_PARTIAL_UPDATE_FAILURE("BRD004", "Some brands not found for update", HttpStatus.NOT_FOUND),

    // Validation Errors
    INVALID_BRAND_DATA("VAL001", "Invalid brand data", HttpStatus.BAD_REQUEST),
    DUPLICATE_BRANDS_IN_LIST("VAL002", "Duplicate brands exist in the provided list", HttpStatus.CONFLICT),

    // New Errors
    INVALID_BRAND_LIST("VAL003", "The brand list is invalid", HttpStatus.BAD_REQUEST),
    BRANDS_ALREADY_EXISTS("BRD005", "Some brands already exist in the provided list", HttpStatus.CONFLICT),
    BRANDS_NOT_FOUND("BRD006", "Some brands were not found in the database", HttpStatus.NOT_FOUND),
    CATEGORY_NOT_FOUND("CAT001", "Category not found with the provided ID", HttpStatus.NOT_FOUND),
    CATEGORIES_NOT_FOUND("CAT002", "No categories found", HttpStatus.NOT_FOUND),

    INVALID_PRODUCT_PAGE2_DATA("VAL004", "Variation and Manufacturer details are required", HttpStatus.BAD_REQUEST),
    PRODUCT_VARIATION_NOT_FOUND("PROD003", "Product variation not found", HttpStatus.NOT_FOUND), // Add this line
    PRODUCT_NOT_FOUND("ERR002", "Product not found", HttpStatus.NOT_FOUND),

    INVALID_FILE_DATA("FILE001", "Invalid file data", HttpStatus.BAD_REQUEST),
    FILE_SIZE_EXCEEDS_LIMIT("FILE002", "File size exceeds the allowed limit", HttpStatus.BAD_REQUEST),
    FILE_PROCESSING_ERROR("FILE003", "Error processing the file", HttpStatus.INTERNAL_SERVER_ERROR),
    FILE_SAVE_ERROR("FILE004", "Unexpected error occurred while saving the file", HttpStatus.INTERNAL_SERVER_ERROR),

    INVALID_PRODUCT_DATA("PRD001", "Invalid product data", HttpStatus.BAD_REQUEST),
    PRODUCT_UPDATE_FAILED("PRD003", "Failed to update the product", HttpStatus.INTERNAL_SERVER_ERROR),
    ADMIN_NOT_FOUND("A001", "Admin not found", HttpStatus.NOT_FOUND),

    SUBCATEGORY_NOT_FOUND("SUB001", "Subcategory not found with the provided ID", HttpStatus.NOT_FOUND),
    SUBCATEGORIES_NOT_FOUND("SUB002", "Some subcategories were not found in the database", HttpStatus.NOT_FOUND),
    INVALID_SUBCATEGORY_DATA("SUB003", "Invalid subcategory data", HttpStatus.BAD_REQUEST),
    DUPLICATE_SUBCATEGORY("SUB004", "Duplicate subcategory exists in the provided list", HttpStatus.CONFLICT),
    SELLER_NOT_FOUND("E001", "Seller not found", HttpStatus.NOT_FOUND),
    SELLER_ALREADY_EXISTS("E002", "Seller already exists", HttpStatus.CONFLICT),
    GST_NUMBER_ALREADY_EXISTS("E003", "GST number already exists", HttpStatus.CONFLICT),
    BANK_ACCOUNT_NUMBER_ALREADY_EXISTS("E004", "Bank account number already exists", HttpStatus.CONFLICT),
    STORE_NAME_ALREADY_EXISTS("E005", "Store name already exists", HttpStatus.CONFLICT),
    BANK_DETAILS_NOT_FOUND("E006", "Bank details not found", HttpStatus.CONFLICT),
    STORE_DETAILS_NOT_FOUND("E007", "Store details not found", HttpStatus.CONFLICT),
    BUSINESS_DETAILS_NOT_FOUND("E008", "Business details not found", HttpStatus.CONFLICT),
    INVALID_BUSINESS_DETAILS("E009", "Invalid business details", HttpStatus.BAD_REQUEST),
    INVALID_BANK_DETAILS("E010", "Invalid bank details", HttpStatus.BAD_REQUEST),
    INVALID_STORE_DETAILS("E011", "Invalid store details", HttpStatus.BAD_REQUEST),
    INVALID_SELLER_DATA("E012", "Invalid seller data", HttpStatus.BAD_REQUEST),
    INVALID_SELLER_ID("E013", "Invalid seller ID", HttpStatus.BAD_REQUEST),

    INVALID_USER_DATA("USR001", "Invalid user data", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND("USR002", "User not found", HttpStatus.NOT_FOUND),
    USER_ALREADY_EXISTS("USR003", "User already exists", HttpStatus.CONFLICT),
    INVALID_USER_ID("USR004", "Invalid user ID", HttpStatus.BAD_REQUEST),
    INVALID_USER_ROLE("USR005", "Invalid user role", HttpStatus.BAD_REQUEST),

    INVALID_ORDER_DATA("ORD001", "Invalid order data", HttpStatus.BAD_REQUEST),
    ORDER_NOT_FOUND("ORD002", "Order not found", HttpStatus.NOT_FOUND),
    INVALID_ORDER_ID("ORD003", "Invalid order ID", HttpStatus.BAD_REQUEST),
    INVALID_ORDER_STATUS("ORD004", "Invalid order status", HttpStatus.BAD_REQUEST),
    INVALID_ORDER_ITEM_DATA("ORD005", "Invalid order item data", HttpStatus.BAD_REQUEST),
    ORDER_ITEM_NOT_FOUND("ORD006", "Order item not found", HttpStatus.NOT_FOUND),
    INVALID_ORDER_ITEM_ID("ORD007", "Invalid order item ID", HttpStatus.BAD_REQUEST),
    INVALID_ORDER_ITEM_QUANTITY("ORD008", "Invalid order item quantity", HttpStatus.BAD_REQUEST),
    INVALID_ORDER_ITEM_STATUS("ORD009", "Invalid order item status", HttpStatus.BAD_REQUEST),
    INVALID_ORDER_ITEM_PRICE("ORD010", "Invalid order item price", HttpStatus.BAD_REQUEST),

    WAREHOUSE_NOT_FOUND("WAREHOUSE-404", "The requested warehouse was not found.", HttpStatus.NOT_FOUND),
    WAREHOUSE_ALREADY_EXIST("WAREHOUSE-101", "A warehouse with the given name already exists.", HttpStatus.BAD_REQUEST),
    INVALID_WAREHOUSE_DATA("WAREHOUSE-102", "The provided warehouse data is invalid.", HttpStatus.BAD_REQUEST),
    WAREHOUSE_DELETION_FAILED("WAREHOUSE-103", "Failed to delete the warehouse. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR),
    WAREHOUSE_UPDATE_FAILED("WAREHOUSE-104", "Failed to update the warehouse. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR),
    WAREHOUSE_CREATION_FAILED("WAREHOUSE-105", "Failed to create the warehouse. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR),

    INVENTORY_NOT_FOUND("INV101", "Inventory record not found.", HttpStatus.NOT_FOUND),
    INVENTORY_ALREADY_EXISTS("INV102", "Inventory record already exists.", HttpStatus.CONFLICT),
    UNAUTHORIZED_ACCESS("INV103", "Unauthorized access.", HttpStatus.FORBIDDEN),
    SERVER_ERROR("INV104", "Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR),
    PRICE_UPDATE_FAILED("INV105", "Price update failed.", HttpStatus.BAD_REQUEST),
    BULK_OPERATION_FAILED("INV106", "Bulk operation failed.", HttpStatus.INTERNAL_SERVER_ERROR),

    // Customer-Specific Errors
    CUSTOMER_ALREADY_EXISTS("CUS001", "Customer already exists with the provided details", HttpStatus.CONFLICT),
    CUSTOMER_NOT_FOUND("CUS002", "Customer not found with the provided ID", HttpStatus.NOT_FOUND),
    CUSTOMER_LIST_EMPTY("CUS003", "Customer list cannot be null or empty", HttpStatus.BAD_REQUEST),
    CUSTOMER_PARTIAL_UPDATE_FAILURE("CUS004", "Some customers were not found for update", HttpStatus.NOT_FOUND),
    INVALID_CUSTOMER_DATA("CUS005", "Invalid customer data", HttpStatus.BAD_REQUEST),
    CUSTOMER_UPDATE_FAILED("CUS006", "Failed to update the customer", HttpStatus.INTERNAL_SERVER_ERROR),
    CUSTOMER_DELETION_FAILED("CUS007", "Failed to delete the customer", HttpStatus.INTERNAL_SERVER_ERROR),
    CUSTOMER_ALREADY_ACTIVE("CUS008", "Customer is already marked as active", HttpStatus.CONFLICT),
    CUSTOMER_INACTIVE("CUS009", "Customer is inactive and cannot perform this action", HttpStatus.FORBIDDEN),

    PAYMENT_EXISTS("E002", "Payment method already exists",HttpStatus.CONFLICT),
    PAYMENT_METHODS_ALREADY_EXIST("E003", "All provided payment methods already exist",HttpStatus.CONFLICT),

    CART_NOT_FOUND("E004", "Cart not found for the given customer", HttpStatus.NOT_FOUND),
    CART_ITEM_NOT_FOUND("E005", "Cart item not found", HttpStatus.NOT_FOUND),
    CART_EMPTY("E006", "Cart is empty", HttpStatus.BAD_REQUEST),
    CART_UPDATE_FAILED("E007", "Failed to update the cart", HttpStatus.INTERNAL_SERVER_ERROR),

    PRODUCT_NOT_BELONG_TO_SELLER("PRD004", "Product does not belong to the seller", HttpStatus.BAD_REQUEST),
    PRODUCT_OUT_OF_STOCK("PRD005", "Product is out of stock", HttpStatus.BAD_REQUEST),


    INVALID_OFFER_DISCOUNT("OFF001", "Invalid offer discount", HttpStatus.BAD_REQUEST),
    INVALID_OFFER_PRICE("OFF002", "Invalid offer price", HttpStatus.BAD_REQUEST),
    PRODUCT_ALREADY_IN_OFFER("OFF003", "Product is already in an offer", HttpStatus.CONFLICT),
    INVALID_OFFER_ID("OFF004", "Invalid offer ID", HttpStatus.NOT_FOUND),


    IMAGE_NOT_FOUND("IMG001", "Invalid image url",  HttpStatus.BAD_REQUEST),
    // General errors
    INVALID_STOCK_ENTRY_DATA("STK001", "Invalid stock entry data provided", HttpStatus.BAD_REQUEST),
    STOCK_ENTRY_NOT_FOUND("STK002", "Stock entry not found", HttpStatus.NOT_FOUND),
    STOCK_ENTRY_ALREADY_EXISTS("STK003", "Stock entry already exists", HttpStatus.CONFLICT),

    // Validation errors
    INVALID_QUANTITY("STK004", "Quantity must be greater than zero", HttpStatus.BAD_REQUEST),
    INVALID_TIMESTAMP("STK005", "Invalid timestamp provided", HttpStatus.BAD_REQUEST),
    MISSING_PRODUCT_VARIATION("STK006", "Product variation details are required", HttpStatus.BAD_REQUEST),
    MISSING_WAREHOUSE("STK007", "Warehouse details are required", HttpStatus.BAD_REQUEST),
    MISSING_SELLER("STK008", "Seller details are required", HttpStatus.BAD_REQUEST),

    // Business rule violations
    STOCK_ENTRY_NOT_APPROVED("STK009", "Stock entry is not approved", HttpStatus.FORBIDDEN),
    STOCK_ENTRY_APPROVAL_FAILED("STK010", "Failed to approve stock entry", HttpStatus.INTERNAL_SERVER_ERROR),
    STOCK_ENTRY_QUANTITY_EXCEEDS_LIMIT("STK011", "Quantity exceeds the allowed limit", HttpStatus.BAD_REQUEST),
    STOCK_ENTRY_IS_APPROVED("STK012", "Stock entry is in approved state", HttpStatus.INTERNAL_SERVER_ERROR),
    STOCK_ENTRY_ACTION_TAKEN("STK013", "Stock entry is already processed", HttpStatus.BAD_REQUEST),


    // System errors
    STOCK_ENTRY_PROCESSING_ERROR("STK015", "Error processing stock entry", HttpStatus.INTERNAL_SERVER_ERROR),


    PARTNER_NOT_FOUND("P0001", "Partner not found", HttpStatus.BAD_REQUEST),


   NOT_ELIGIBLE_FOR_PARTNERSHIP("P0002", "Not eligible for partnership", HttpStatus.FORBIDDEN),
   PARTNER_NOT_ACTIVE("P0003", "Partner is not active", HttpStatus.FORBIDDEN),
    // Partner Management Errors
  //  PARTNER_NOT_FOUND("PTR001", "Partner not found", HttpStatus.NOT_FOUND),
    INVALID_STATUS_TRANSITION("PTR002", "Invalid status transition", HttpStatus.BAD_REQUEST),
    PARTNER_ALREADY_ACTIVE("PTR003", "Partner is already active", HttpStatus.BAD_REQUEST),
    PARTNER_DOCUMENTS_INCOMPLETE("PTR004", "Partner documents are incomplete", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED_OPERATION("PTR005", "Unauthorized operation", HttpStatus.FORBIDDEN),
    INVALID_SEARCH_CRITERIA("PTR006", "Invalid search criteria", HttpStatus.BAD_REQUEST),
  //  BULK_OPERATION_FAILED("PTR007", "Bulk operation failed", HttpStatus.INTERNAL_SERVER_ERROR),
    //
  // Offering Specific Errors
  OFFERING_NOT_FOUND("OFF001", "Offering not found", HttpStatus.NOT_FOUND),
    INVALID_STAGE_TRANSITION("OFF002", "Invalid stage transition", HttpStatus.BAD_REQUEST),
   // PARTNER_NOT_FOUND("OFF003", "Partner not found", HttpStatus.NOT_FOUND),
    PARTNER_NOT_VERIFIED("OFF004", "Partner not verified for this stage", HttpStatus.BAD_REQUEST),
    OFFERING_ALREADY_PUBLISHED("OFF005", "Offering is already published", HttpStatus.BAD_REQUEST),
    INSUFFICIENT_DOCUMENTATION("OFF006", "Insufficient documentation for approval", HttpStatus.BAD_REQUEST),
    INVALID_PRICING_CONFIGURATION("OFF007", "Invalid pricing configuration", HttpStatus.BAD_REQUEST),
    MEDIA_VALIDATION_FAILED("OFF008", "Media validation failed", HttpStatus.BAD_REQUEST),

    // Admin Specific Errors
    UNAUTHORIZED_ADMIN_ACTION("ADM001", "Unauthorized admin action", HttpStatus.FORBIDDEN),
   // ADMIN_NOT_FOUND("ADM002", "Admin not found", HttpStatus.NOT_FOUND),
    INSUFFICIENT_ADMIN_PRIVILEGES("ADM003", "Insufficient admin privileges", HttpStatus.FORBIDDEN)
    ,
    REJECTION_REASON_REQUIRED("OFF007", "Rejection reason is required", HttpStatus.BAD_REQUEST),
    SOME_OFFERINGS_NOT_FOUND("OFF009", "Some offerings in the bulk request were not found", HttpStatus.NOT_FOUND);

    ;
    ;



    private final String exceptionCode;
    private final String message;
    private final HttpStatus httpStatus;

    ErrorEnum(String exceptionCode, String message, HttpStatus httpStatus) {
        this.exceptionCode = exceptionCode;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String toString() {
        return String.format("ErrorEnum{code='%s', message='%s', httpStatus=%s}", exceptionCode, message, httpStatus);
    }

}
