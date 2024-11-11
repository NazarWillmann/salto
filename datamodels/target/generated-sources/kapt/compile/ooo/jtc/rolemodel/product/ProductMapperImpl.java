package ooo.jtc.rolemodel.product;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toDomainModel(ProductDto dto) {
        if ( dto == null ) {
            return null;
        }

        ProductBuilder product = ProductBuilder.builder();

        product.setId( dto.getId() );
        product.setVersion( dto.getVersion() );
        product.setName( dto.getName() );
        product.setUiName( dto.getUiName() );
        product.setDescription( dto.getDescription() );
        product.setPath( dto.getPath() );

        return product.create();
    }

    @Override
    public ProductDto toDto(Product domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        ProductDtoBuilder productDto = ProductDtoBuilder.builder();

        productDto.setId( domainModel.getId() );
        productDto.setVersion( domainModel.getVersion() );
        productDto.setName( domainModel.getName() );
        productDto.setUiName( domainModel.getUiName() );
        productDto.setDescription( domainModel.getDescription() );
        productDto.setPath( domainModel.getPath() );

        return productDto.create();
    }
}
