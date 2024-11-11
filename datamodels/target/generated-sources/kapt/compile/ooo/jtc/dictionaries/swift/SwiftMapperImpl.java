package ooo.jtc.dictionaries.swift;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-01T16:00:41+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8-internal (N/A)"
)
public class SwiftMapperImpl implements SwiftMapper {

    @Override
    public Swift toDomainModel(SwiftDto dto) {
        if ( dto == null ) {
            return null;
        }

        SwiftBuilder swift = SwiftBuilder.builder();

        swift.setId( dto.getId() );
        swift.setVersion( dto.getVersion() );
        swift.setSwift( dto.getSwift() );
        swift.setInstitutionType( dto.getInstitutionType() );
        swift.setDateActual( dto.getDateActual() );
        swift.setName( dto.getName() );
        swift.setCity( dto.getCity() );
        swift.setAddress1( dto.getAddress1() );
        swift.setAddress2( dto.getAddress2() );
        swift.setAddress3( dto.getAddress3() );
        swift.setAddress4( dto.getAddress4() );
        swift.setBranchName( dto.getBranchName() );
        swift.setBranchCity( dto.getBranchCity() );
        swift.setBranchAddress1( dto.getBranchAddress1() );
        swift.setBranchAddress2( dto.getBranchAddress2() );
        swift.setBranchAddress3( dto.getBranchAddress3() );
        swift.setBranchAddress4( dto.getBranchAddress4() );
        swift.setCountryAlpha2Code( dto.getCountryAlpha2Code() );

        return swift.create();
    }

    @Override
    public SwiftDto toDto(Swift domainModel) {
        if ( domainModel == null ) {
            return null;
        }

        SwiftDtoBuilder swiftDto = SwiftDtoBuilder.builder();

        swiftDto.setId( domainModel.getId() );
        swiftDto.setVersion( domainModel.getVersion() );
        swiftDto.setSwift( domainModel.getSwift() );
        swiftDto.setInstitutionType( domainModel.getInstitutionType() );
        swiftDto.setDateActual( domainModel.getDateActual() );
        swiftDto.setName( domainModel.getName() );
        swiftDto.setCity( domainModel.getCity() );
        swiftDto.setAddress1( domainModel.getAddress1() );
        swiftDto.setAddress2( domainModel.getAddress2() );
        swiftDto.setAddress3( domainModel.getAddress3() );
        swiftDto.setAddress4( domainModel.getAddress4() );
        swiftDto.setBranchName( domainModel.getBranchName() );
        swiftDto.setBranchCity( domainModel.getBranchCity() );
        swiftDto.setBranchAddress1( domainModel.getBranchAddress1() );
        swiftDto.setBranchAddress2( domainModel.getBranchAddress2() );
        swiftDto.setBranchAddress3( domainModel.getBranchAddress3() );
        swiftDto.setBranchAddress4( domainModel.getBranchAddress4() );
        swiftDto.setCountryAlpha2Code( domainModel.getCountryAlpha2Code() );

        return swiftDto.create();
    }
}
